package com.example.tyb2.domain.workout.usecases

import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.repository.WorkoutRepository

class GetWorkoutsUseCase(private val repository: WorkoutRepository) {
    fun invoke(onComplete: ((List<Workout>?) -> Unit)? = null) {
        return repository.getWorkoutsLegacy(onComplete)
    }
}