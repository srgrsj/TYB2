package com.example.tyb2.presentation.screens.main.workoutpPlayback

import androidx.lifecycle.ViewModel
import com.example.tyb2.domain.app.usecase.AppUseCases
import com.example.tyb2.domain.workout.model.Workout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class WorkoutPlaybackViewModel @Inject constructor(
    appUseCases: AppUseCases
) : ViewModel() {
    val currentWorkout: StateFlow<Workout?> = appUseCases.getCurrentWorkoutUseCase()

}