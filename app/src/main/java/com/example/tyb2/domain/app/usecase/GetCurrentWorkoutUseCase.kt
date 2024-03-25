package com.example.tyb2.domain.app.usecase

import com.example.tyb2.domain.app.repository.AppRepository
import com.example.tyb2.domain.workout.model.Workout
import kotlinx.coroutines.flow.StateFlow

class GetCurrentWorkoutUseCase(val repository: AppRepository) {
    operator fun invoke(): StateFlow<Workout?> {
        return repository.currentWorkout
    }
}