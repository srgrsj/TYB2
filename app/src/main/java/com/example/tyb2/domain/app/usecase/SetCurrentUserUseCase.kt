package com.example.tyb2.domain.app.usecase

import com.example.tyb2.domain.app.repository.AppRepository
import com.example.tyb2.domain.user.model.User

class SetCurrentUserUseCase(val repository: AppRepository) {
    suspend operator fun invoke(user: User?) {
        repository.setCurrentUser(user)
    }
}