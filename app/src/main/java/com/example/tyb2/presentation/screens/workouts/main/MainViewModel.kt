package com.example.tyb2.presentation.screens.workouts.main

import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import com.example.tyb2.presentation.screens.workouts.WorkoutsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    workoutUseCase: WorkoutUseCase
) : WorkoutsViewModel(workoutUseCase) {

}