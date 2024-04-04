package com.example.tyb2.domain.app.usecase

import com.example.tyb2.domain.app.repository.AppRepository
import com.example.tyb2.domain.workout.model.Workout

class SetAvatarUseCase(val repository: AppRepository) {
    suspend operator fun invoke(avatar: Int) {
        repository.setAvatar(avatar)
    }
}