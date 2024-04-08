package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.user.repository.UserRepository
import com.example.tyb2.domain.workout.model.Workout


class GetSignedInUserUseCase(private val repository: UserRepository) {
    suspend operator fun invoke() = repository.getSignedInUser()
}