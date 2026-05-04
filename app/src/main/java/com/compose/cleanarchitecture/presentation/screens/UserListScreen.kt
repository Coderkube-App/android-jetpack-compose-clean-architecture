package com.compose.cleanarchitecture.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.cleanarchitecture.core.designsystem.animations.FadeInVisibility
import com.compose.cleanarchitecture.core.designsystem.components.AppTopBar
import com.compose.cleanarchitecture.core.designsystem.layouts.ResponsiveScaffold
import com.compose.cleanarchitecture.core.designsystem.layouts.rememberWindowSize
import com.compose.cleanarchitecture.core.designsystem.tokens.appScreenPadding
import com.compose.cleanarchitecture.core.designsystem.tokens.standardCardStyle
import com.compose.cleanarchitecture.domain.model.User
import com.compose.cleanarchitecture.presentation.viewmodel.UserViewModel

@Composable
fun UserListScreen(viewModel: UserViewModel) {
    val state by viewModel.state.collectAsState()
    val windowSize = rememberWindowSize()

    ResponsiveScaffold(
        windowSize = windowSize,
        topBar = {
            AppTopBar(title = "Clean Architecture")
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            FadeInVisibility(visible = state.isLoading, modifier = Modifier.align(Alignment.Center)) {
                CircularProgressIndicator()
            }

            if (state.error != null) {
                ErrorMessage(message = state.error!!, onRetry = { viewModel.getUsers() })
            }

            if (state.users.isNotEmpty()) {
                UserList(users = state.users)
            }
        }
    }
}

@Composable
fun UserList(users: List<User>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(users) { user ->
            UserItem(user = user)
        }
    }
}

@Composable
fun UserItem(user: User) {
    Column(
        modifier = Modifier
            .standardCardStyle()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = user.name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        UserInfoRow(icon = Icons.Default.Email, text = user.email)
        UserInfoRow(icon = Icons.Default.Phone, text = user.phone)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Surface(
            color = MaterialTheme.colorScheme.secondaryContainer,
            shape = MaterialTheme.shapes.small
        ) {
            Text(
                text = user.company.name,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Composable
fun UserInfoRow(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun ErrorMessage(message: String, onRetry: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .appScreenPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onRetry) {
            Text("Retry")
        }
    }
}
