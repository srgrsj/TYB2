package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.repository.UserRepository

class SaveOnboardingIsShow(
    private val repository: UserRepository
) {
    suspend operator fun invoke() {
        repository.saveOnboardingIsShow()
    }
}