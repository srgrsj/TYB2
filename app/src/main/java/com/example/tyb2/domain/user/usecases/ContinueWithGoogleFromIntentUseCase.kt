package com.example.tyb2.domain.user.usecases

import android.content.Intent
import com.example.tyb2.domain.user.repository.UserRepository


class ContinueWithGoogleFromIntentUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(intent: Intent) {
        repository.getContinueWithGoogleFromIntent(intent)
    }
}