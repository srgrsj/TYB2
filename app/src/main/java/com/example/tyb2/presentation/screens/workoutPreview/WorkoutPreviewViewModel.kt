package com.example.tyb2.presentation.screens.workoutPreview

import androidx.lifecycle.ViewModel
import com.example.tyb2.domain.app.usecase.AppUseCases
import com.example.tyb2.domain.workout.model.Workout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
open class WorkoutPreviewViewModel @Inject constructor(
    private val appUseCases: AppUseCases
) : ViewModel() {
    val currentWorkout: StateFlow<Workout?> = appUseCases.getCurrentWorkoutUseCase()
}