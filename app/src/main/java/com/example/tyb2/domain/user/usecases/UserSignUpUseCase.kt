package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.repository.UserRepository
import com.example.tyb2.util.Resource
import com.google.firebase.auth.AuthResult

import kotlinx.coroutines.flow.Flow

class UserSignUpUseCase(private val repository: UserRepository) {
    operator fun invoke(email: String, password: String): Flow<Resource<AuthResult>> {
        return repository.registerUser(email, password)
    }
}