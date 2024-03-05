package com.example.tyb2.presentation.screens.main

import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    workoutUseCase: WorkoutUseCase
) : WorkoutsViewModel(workoutUseCase) {

}