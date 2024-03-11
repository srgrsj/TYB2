package com.example.tyb2.presentation.screens.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.data.user.AccountData
import com.example.tyb2.domain.user.usecases.UserUseCase
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase
    ) : ViewModel() {
    private var _createdWorkoutList = MutableStateFlow(emptyList<Workout>())
    val createdWorkoutList: StateFlow<List<Workout>> = _createdWorkoutList.asStateFlow()

    init {
        saveWorkoutsFromRealtimeDatabaseToWorkoutList()
    }

    private fun saveWorkoutsFromRealtimeDatabaseToWorkoutList() {

        workoutUseCase.getWorkoutsUseCase.invoke {
            if (it != null) {
                viewModelScope.launch {
                    _createdWorkoutList.emit(it)
                }
            }
        }

    }
}