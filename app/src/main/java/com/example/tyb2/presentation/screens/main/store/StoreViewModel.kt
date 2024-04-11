package com.example.tyb2.presentation.screens.main.store

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import com.aallam.openai.api.moderation.Categories
import com.example.tyb2.domain.app.usecase.AppUseCases
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import com.example.tyb2.presentation.screens.main.WorkoutsViewModel
import com.example.tyb2.util.Muscle
import com.example.tyb2.util.MuscleGroup
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
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
    ): List<Workout> {
        if (allCategories) return readyWorkoutList.value
        val sortedList = mutableListOf<Workout>()
        readyWorkoutList.value.forEach { workout ->
            workout.muscles?.forEach {
                if (sortCategories.contains(it)) sortedList.add(workout)
            }
        }
//        Log.i("list", sortedList.toString())
//        Log.i("category", sortCategories.toString())
        return sortedList.distinct()
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