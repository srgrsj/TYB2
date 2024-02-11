package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.repository.UserRepository


class UserSignOutUseCase(private val repository: UserRepository) {
    operator fun invoke() {
        repository.singOutUser()
    }
}