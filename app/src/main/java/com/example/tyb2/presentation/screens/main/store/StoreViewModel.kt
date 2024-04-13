package com.example.tyb2.presentation.screens.main.store

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.tyb2.domain.app.usecase.AppUseCases
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import com.example.tyb2.presentation.screens.main.WorkoutsViewModel
import com.example.tyb2.util.Muscle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class StoreViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase,
    private val appUseCases: AppUseCases
) : WorkoutsViewModel(workoutUseCase) {

//    val sortedWorkoutList: StateFlow<List<Workout>> = _workoutList.asStateFlow()
//    val readySortedWorkoutList: StateFlow<List<Workout>> = _readyWorkoutList.asStateFlow()

    val defaultCategories: List<Muscle> = mutableListOf(
            Muscle.BREAST,
            Muscle.ARM_BICEPS,
            Muscle.ARM_FOREARM,
            Muscle.ARM_TRICEPS,
            Muscle.BACK_TRAPEZOID,
            Muscle.BACK_WIDE,
            Muscle.BRACHIAL_BACK,
            Muscle.BRACHIAL_FRONT,
            Muscle.CORE_LATERAL_ABDOMINAL,
            Muscle.CORE_LUMBAR,
            Muscle.CORE_STRAIGHT,
            Muscle.LEG_CALF,
            Muscle.LEG_THIGHS,
            Muscle.LEG_QUADRICEPS,
    )


    fun sortWorkoutListByCategory(
        sortCategories: List<Muscle>,
        allCategories: Boolean,
    ) {
        if (allCategories) viewModelScope.launch { _allWorkoutsList.emit(allWorkoutsList.value) }
        val sortedList = mutableListOf<Workout>()
        allWorkoutsList.value.forEach { workout ->
            workout.muscles?.forEach {
                if (sortCategories.contains(it)) sortedList.add(workout)
            }
        }
        Log.i("Vm sorted", sortedList.toString())
        viewModelScope.launch {
            _allWorkoutsList.emit(sortedList)
        }
    }

    fun changeWorkoutFavState(workout: Workout) {
        val updatedWorkoutList = workoutList.value.map { existingWorkout ->
            if (existingWorkout.id == workout.id) {
                existingWorkout.copy(isInFav = !(existingWorkout.isInFav ?: false))
            } else {
                existingWorkout
            }
        }
        viewModelScope.launch {
            _workoutList.emit(updatedWorkoutList)
            workoutUseCase.changeWorkoutFavState(workout = workout)
        }
    }
}