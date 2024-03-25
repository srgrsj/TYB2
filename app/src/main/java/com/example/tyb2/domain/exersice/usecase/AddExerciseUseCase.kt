package com.example.tyb2.domain.exersice.usecase

import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.repository.ExerciseRepository

class AddExerciseUseCase(private val repository: ExerciseRepository) {
    suspend fun invoke(exercise: Exercise) {
        repository.insertExercise(exercise = exercise)
    }
}