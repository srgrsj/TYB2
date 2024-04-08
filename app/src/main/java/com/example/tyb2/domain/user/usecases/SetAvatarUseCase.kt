package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class SetAvatarUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(value: String) =
        repository.setUserAvatar(value)
}