package com.compose.cleanarchitecture.domain.usecase

import com.compose.cleanarchitecture.domain.model.User
import com.compose.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(page: Int): ArrayList<User> = repository.getUsers(page)
}
