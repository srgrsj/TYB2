package com.example.tyb2.presentation.screens.generators

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class GeneratorsScreenViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase
) : ViewModel() {
    fun saveWorkoutToRealtimeDatabase(workout: Workout) {
        viewModelScope.launch {
            workoutUseCase.addWorkoutUseCase.invoke(workout)
        }
    }

}