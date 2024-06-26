package com.example.tyb2.domain.app.usecase

data class AppUseCases(
    val getCurrentWorkoutUseCase: GetCurrentWorkoutUseCase,
    val setCurrentWorkoutUseCase: SetCurrentWorkoutUseCase,
    val getCurrentUserUseCase: GetCurrentUserUseCase,
    val setCurrentUserUseCase: SetCurrentUserUseCase,
)
