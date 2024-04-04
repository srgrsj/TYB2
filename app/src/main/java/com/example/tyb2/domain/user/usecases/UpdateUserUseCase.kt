package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.user.repository.UserRepository

class UpdateUserUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(user: User) {
        repository.updateUser(user)
    }
}