package com.example.tyb2.domain.exersice.repository

import com.example.tyb2.domain.exersice.model.Exercise

interface ExerciseRepository {
    suspend fun getExercises(): List<Exercise>?

    suspend fun insertExercise(exercise: Exercise)

    suspend fun deleteExercise(exercise: Exercise)
}