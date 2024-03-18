package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.repository.UserRepository
import com.example.tyb2.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

class ContinueWithGoogleUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(credential: AuthCredential): Flow<Resource<AuthResult>> =
        repository.continueWithGoogle(credential)
}