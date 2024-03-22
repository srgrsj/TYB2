package com.example.tyb2.presentation.screens.main

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.readyWorkoutsData.ReadyWorkouts
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    workoutUseCase: WorkoutUseCase
) : WorkoutsViewModel(workoutUseCase) {


}