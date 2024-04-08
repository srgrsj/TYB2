package com.example.tyb2.presentation.screens.profile.calendar

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.R
import com.example.tyb2.domain.app.usecase.AppUseCases
import com.example.tyb2.domain.user.model.User
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
class CalendarViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
    private val appUseCases: AppUseCases,
    private val workoutUseCase: WorkoutUseCase,
) : ViewModel() {

//    private val _userData = MutableStateFlow<User?>(null)
//    val userData: StateFlow<User?> = _userData

    private val _userAvatar = MutableStateFlow<String>("n")
    val userAvatar: StateFlow<String> = _userAvatar
    fun getUserAvatarData() {
        viewModelScope.launch {
            _userAvatar.emit(userUseCase.getAvatarUseCase.invoke().toString())
        }
    }
    fun setUserAvatarData(value: String) = viewModelScope.launch {
        userUseCase.setAvatarUseCase.invoke(value)
    }

    fun setCurrentWorkout(workout: Workout) {
        viewModelScope.launch {
            appUseCases.setCurrentWorkoutUseCase.invoke(workout)
        }
    }

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


//    fun updateUser(user: User) = viewModelScope.launch {
//        Log.i("test view model", user.toString())
//        userUseCase.updateUserUseCase.invoke(user)
//        _userData.value = user
//    }

//    fun setAvatar() = viewModelScope.launch {
////        appUseCases.setCurrentUserUseCase.invoke(getUserAvatar(getUserData()?.userGenderIsMan))
//    }
}