package com.compose.cleanarchitecture.core.designsystem.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.compose.cleanarchitecture.core.designsystem.components.AppBottomNavigation
import com.compose.cleanarchitecture.core.designsystem.components.NavigationItem

@Composable
fun ResponsiveScaffold(
    windowSize: WindowSize,
    topBar: @Composable () -> Unit = {},
    bottomBarItems: List<NavigationItem> = emptyList(),
    currentRoute: String? = null,
    onNavigate: (NavigationItem) -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    val isTablet = windowSize.width != WindowSizeClass.Compact

    Scaffold(
        topBar = topBar,
        bottomBar = {
            if (!isTablet && bottomBarItems.isNotEmpty()) {
                AppBottomNavigation(
                    items = bottomBarItems,
                    currentRoute = currentRoute,
                    onItemClick = onNavigate
                )
            }
        }
    ) { innerPadding ->
        Row(modifier = Modifier.fillMaxSize()) {
            if (isTablet && bottomBarItems.isNotEmpty()) {
                NavigationRail(
                    modifier = Modifier.fillMaxHeight(),
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface
                ) {
                    bottomBarItems.forEach { item ->
                        NavigationRailItem(
                            selected = currentRoute == item.route,
                            onClick = { onNavigate(item) },
                            icon = { Icon(item.icon, contentDescription = item.title) },
                            label = { Text(item.title) }
                        )
                    }
                }
            }
            Box(modifier = Modifier.weight(1f)) {
                content(innerPadding)
            }
        }
    }
}
