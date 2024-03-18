package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.repository.UserRepository

class ContinueWithGoogleUseCase(private val repository: UserRepository) {
    suspend operator fun invoke() {
        repository.continueWithGoogle()
    }
}