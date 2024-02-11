package com.example.tyb2.domain.workout.usecases

import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.repository.WorkoutRepository


class AddWorkoutUseCase(private val repository: WorkoutRepository) {
    suspend fun invoke(workout: Workout) {
        repository.insertWorkout(workout = workout)
    }
}