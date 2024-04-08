package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.repository.UserRepository
import com.example.tyb2.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

class GetAvatarUseCase(private val repository: UserRepository) {
    operator fun invoke(): Flow<String> = repository.getUserAvatar()
}
