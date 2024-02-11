package com.example.tyb2.domain.workout.usecases

import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.repository.WorkoutRepository


class ChangeWorkoutFavState(private val repository: WorkoutRepository) {
    suspend operator fun invoke(workout: Workout) {
        repository.changeWorkoutFavState(workout = workout)
    }
}