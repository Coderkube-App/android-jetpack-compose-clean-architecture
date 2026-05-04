package com.compose.cleanarchitecture.data.repository

import com.compose.cleanarchitecture.domain.model.User
import com.compose.cleanarchitecture.domain.repository.UserRepository
import com.compose.cleanarchitecture.data.remote.api.ApiService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {
    override suspend fun getUsers(page: Int): ArrayList<User> = apiService.getUsers(page)
}
