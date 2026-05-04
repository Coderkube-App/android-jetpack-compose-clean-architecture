package com.compose.cleanarchitecture.core.designsystem.layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowSizeClass { Compact, Medium, Expanded }

data class WindowSize(
    val width: WindowSizeClass,
    val height: WindowSizeClass
)

@Composable
fun rememberWindowSize(): WindowSize {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    return WindowSize(
        width = getWindowSizeClass(screenWidth),
        height = getWindowSizeClass(screenHeight)
    )
}

private fun getWindowSizeClass(size: Dp): WindowSizeClass = when {
    size < 600.dp -> WindowSizeClass.Compact
    size < 840.dp -> WindowSizeClass.Medium
    else -> WindowSizeClass.Expanded
}
