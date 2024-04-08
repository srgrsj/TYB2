package com.example.tyb2.domain.app.usecase

import com.example.tyb2.domain.app.repository.AppRepository
import com.example.tyb2.domain.user.model.User
import kotlinx.coroutines.flow.StateFlow

class GetCurrentUserUseCase(val repository: AppRepository) {
    operator fun invoke(): StateFlow<User?> {
        return repository.currentUser
    }
}