package com.example.tyb2.domain.app.usecase

data class AppUseCases(
    val getCurrentWorkoutUseCase: GetCurrentWorkoutUseCase,
    val setCurrentWorkoutUseCase: SetCurrentWorkoutUseCase,
    val getAvatarUseCase: GetAvatarUseCase,
    val setAvatarUseCase: SetAvatarUseCase,
)
