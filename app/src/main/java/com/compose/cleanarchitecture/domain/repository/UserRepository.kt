package com.compose.cleanarchitecture.domain.repository

import com.compose.cleanarchitecture.domain.model.User

interface UserRepository {
    suspend fun getUsers(page: Int): ArrayList<User>
}
