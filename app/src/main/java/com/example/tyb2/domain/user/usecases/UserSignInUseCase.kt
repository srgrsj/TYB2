package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.repository.UserRepository
import com.example.tyb2.util.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

class UserSignInUseCase(private val repository: UserRepository) {
    operator fun invoke(email: String, password: String): Flow<Resource<AuthResult>> =
        repository.loginUser(email, password)
}