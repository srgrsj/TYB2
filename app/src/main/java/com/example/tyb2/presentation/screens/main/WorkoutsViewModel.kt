package com.example.tyb2.presentation.screens.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.readyWorkoutsData.ReadyWorkouts
import com.example.tyb2.domain.workout.readyYogaData.ReadyYoga
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class WorkoutsViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase,
) : ViewModel() {
    var workoutToDelete: Workout? = null



    private var _workoutList = MutableStateFlow(emptyList<Workout>())
    val workoutList: StateFlow<List<Workout>> = _workoutList.asStateFlow()

    private var _readyWorkoutList = MutableStateFlow(emptyList<Workout>())
    val readyWorkoutList: StateFlow<List<Workout>> = _readyWorkoutList.asStateFlow()

    private var _readyYogaList = MutableStateFlow(emptyList<Workout>())
    val readyYogaList: StateFlow<List<Workout>> = _readyYogaList.asStateFlow()

    init {
        saveWorkoutsFromRealtimeDatabaseToWorkoutList()
    }

    fun getReadyWorkouts(context: Context) {
        val updatedReadyWorkoutList = mutableListOf<Workout>()

        ReadyWorkouts.values().forEach {
            updatedReadyWorkoutList.add(it.getLocalizedWorkout(context))
        }

        viewModelScope.launch {
            _readyWorkoutList.emit(updatedReadyWorkoutList)
        }
    }

    fun getReadyYoga(context: Context) {
        val updatedReadyYogaList = mutableListOf<Workout>()

        ReadyYoga.values().forEach {
            updatedReadyYogaList.add(it.getLocalizedYoga(context))
        }

        viewModelScope.launch {
            _readyWorkoutList.emit(updatedReadyYogaList)
        }
    }

    private fun saveWorkoutsFromRealtimeDatabaseToWorkoutList() {

        workoutUseCase.getWorkoutsUseCase.invoke {
            if (it != null) {
                viewModelScope.launch {
                    _workoutList.emit(it)
                }
            }
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


    private fun deleteWorkoutFromRealtimeDatabase(workout: Workout) {
        viewModelScope.launch {
            workoutUseCase.deleteWorkoutUseCase.invoke(workout = workout)
        }
    }

    private fun deleteWorkoutFromWorkoutList(workout: Workout) {
        val updatedWorkoutList = workoutList.value.toMutableList()
        updatedWorkoutList.remove(workout)
        viewModelScope.launch {
            _workoutList.emit(updatedWorkoutList)
        }
    }

    fun deleteWorkout(workout: Workout) {
        deleteWorkoutFromRealtimeDatabase(workout = workout)
        deleteWorkoutFromWorkoutList(workout = workout)
    }


    private val _showDeleteWorkoutDialog = MutableStateFlow(false)
    val showDeleteWorkoutDialog: StateFlow<Boolean> = _showDeleteWorkoutDialog.asStateFlow()

    fun showDeleteWorkoutAlertDialog() {
        _showDeleteWorkoutDialog.value = true
    }

    fun hideDeleteWorkoutAlertDialog() {
        _showDeleteWorkoutDialog.value = false
    }
}

