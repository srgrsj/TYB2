package com.example.tyb2.presentation.screens.workoutPreview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.domain.app.usecase.AppUseCases
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class WorkoutPreviewViewModel @Inject constructor(
    private val appUseCases: AppUseCases,
    private val workoutUseCase: WorkoutUseCase
) : ViewModel() {
    val currentWorkout: StateFlow<Workout?> = appUseCases.getCurrentWorkoutUseCase()

    fun saveWorkout(workout: Workout) {
        viewModelScope.launch {
            workoutUseCase.addWorkoutUseCase.invoke(workout)
        }
    }
}