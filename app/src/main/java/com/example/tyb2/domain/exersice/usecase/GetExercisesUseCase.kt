package com.example.tyb2.domain.exercise.usecase

import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.repository.ExerciseRepository


class GetExercisesUseCase(private val repository: ExerciseRepository) {
    suspend fun invoke(): List<Exercise>? {
        return repository.getExercises()
    }
}