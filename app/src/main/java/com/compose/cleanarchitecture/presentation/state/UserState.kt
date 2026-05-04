package com.compose.cleanarchitecture.presentation.state

import com.compose.cleanarchitecture.domain.model.User

data class UserState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String? = null
)
