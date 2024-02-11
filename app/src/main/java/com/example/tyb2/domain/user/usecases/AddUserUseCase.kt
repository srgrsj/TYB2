package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.user.repository.UserRepository


class AddUserUseCase(private val repository: UserRepository) {
    suspend fun invoke(user: User) {
        repository.insertUser(user = user)
    }
}