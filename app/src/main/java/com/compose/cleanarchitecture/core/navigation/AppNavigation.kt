package com.compose.cleanarchitecture.core.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.cleanarchitecture.presentation.screens.UserListScreen
import com.compose.cleanarchitecture.presentation.viewmodel.UserViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.UserList.route
    ) {
        composable(Screen.UserList.route) {
            val viewModel: UserViewModel = hiltViewModel()
            UserListScreen(viewModel = viewModel)
        }
        // Add more routes as needed
    }
}
