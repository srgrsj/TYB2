package com.example.tyb2.domain.app.usecase

import com.example.tyb2.domain.app.repository.AppRepository
import com.example.tyb2.domain.workout.model.Workout

class SetCurrentWorkoutUseCase(val repository: AppRepository) {
    suspend operator fun invoke(workout: Workout) {
        repository.setCurrentWorkout(workout)
    }
}