package com.example.tyb2.domain.exercise.usecase

import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.repository.ExerciseRepository


class DeleteExerciseUseCase(private val repository: ExerciseRepository) {
    suspend fun invoke(exercise: Exercise) {
        repository.deleteExercise(exercise = exercise)
    }
}