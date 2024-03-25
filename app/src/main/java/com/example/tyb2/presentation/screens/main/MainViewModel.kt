package com.example.tyb2.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.example.tyb2.domain.app.usecase.AppUseCases
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    workoutUseCase: WorkoutUseCase,
    private val appUseCases: AppUseCases
) : WorkoutsViewModel(workoutUseCase) {
    fun setCurrentWorkout(workout: Workout) {
        viewModelScope.launch {
            appUseCases.setCurrentWorkoutUseCase.invoke(workout)
        }
    }
}