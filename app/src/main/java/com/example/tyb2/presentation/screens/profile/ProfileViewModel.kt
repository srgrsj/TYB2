package com.example.tyb2.presentation.screens.profile

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.R
import com.example.tyb2.data.user.AccountData
import com.example.tyb2.domain.app.usecase.AppUseCases
import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.user.usecases.UserUseCase
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.readyWorkoutsData.ReadyWorkouts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val appUseCases: AppUseCases,
    private val userUseCase: UserUseCase,
) : ViewModel() {


    fun singOutUser() = viewModelScope.launch {
        userUseCase.userSignOutUseCase()

        AccountData.EMAIL = null
        AccountData.ID = null
    }

//    fun getUserPicture() {
//        userUseCase.getSignedInUserUseCase.invoke()
//    }

    private val _userAvatar = MutableStateFlow<String>("n")
    val userAvatar: StateFlow<String> = _userAvatar
    suspend fun getUserAvatarData(): String {
        userAvatar.collect {userUseCase.getAvatarUseCase.invoke()}

//        _userAvatar.emit(data.toString())
        return userAvatar.value
    }
}