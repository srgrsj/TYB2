package com.example.tyb2.domain.exercise.usecase

data class ExerciseUseCase(
    val addExerciseUseCase: AddExerciseUseCase,
    val getExercisesUseCase: GetExercisesUseCase,
    val deleteExerciseUseCase: DeleteExerciseUseCase
)