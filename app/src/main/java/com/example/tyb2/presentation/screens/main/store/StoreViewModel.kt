package com.example.tyb2.presentation.screens.main.store

import com.example.tyb2.domain.app.usecase.AppUseCases
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import com.example.tyb2.presentation.screens.main.WorkoutsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    workoutUseCase: WorkoutUseCase,
    appUseCases: AppUseCases
) : WorkoutsViewModel(workoutUseCase) {

    val sortedWorkoutList: List<Workout> = mutableListOf<Workout>()
//    val sortedWorkoutList: StateFlow<List<Workout>> = _workoutList.asStateFlow()
//    val readySortedWorkoutList: StateFlow<List<Workout>> = _readyWorkoutList.asStateFlow()

//    fun sortWorkoutListByCategory(category: MuscleGroup) {
//        workoutList.forEach {
//
//        }
//    }
}