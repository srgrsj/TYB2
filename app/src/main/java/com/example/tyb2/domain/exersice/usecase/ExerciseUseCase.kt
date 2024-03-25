package com.example.tyb2.domain.exercise.usecase

import com.example.tyb2.domain.exersice.usecase.AddExerciseUseCase

data class ExerciseUseCase(
    val addExerciseUseCase: AddExerciseUseCase,
    val getExercisesUseCase: GetExercisesUseCase,
    val deleteExerciseUseCase: DeleteExerciseUseCase
)