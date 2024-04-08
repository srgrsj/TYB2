package com.example.tyb2.presentation.screens.profile.body_features

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.R
import com.example.tyb2.domain.app.usecase.AppUseCases
import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.user.usecases.UserUseCase
import com.example.tyb2.presentation.screens.profile.ProfileViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BodyFeaturesViewModel @Inject constructor(
    private val appUseCases: AppUseCases,
    private val userUseCase: UserUseCase,
) : ViewModel() {

//    private val _userData = MutableStateFlow<User?>(null)
//    val userData: StateFlow<User?> = _userData

//    fun saveCurrentUser(user: User) {
//        viewModelScope.launch {
//            appUseCases.setCurrentUserUseCase.invoke(user)
//        }
//    }

//    fun getUserAvatar(gender: Boolean?): Int {
//        return when (gender) {
//            null -> R.drawable.profile_avatar_default
//            true -> R.drawable.profile_avatar_man
//            else -> R.drawable.profile_avatar_woman
//        }
//    }

    private val _userAvatar = MutableStateFlow<String>("n")
    val userAvatar: StateFlow<String> = _userAvatar
    suspend fun getUserAvatarData(): String {
        userAvatar.collect {userUseCase.getAvatarUseCase.invoke()}
//        _userAvatar.emit()
        return userAvatar.value
    }

    fun setUserAvatarData(value: String) = viewModelScope.launch {
        userUseCase.setAvatarUseCase.invoke(value)
    }

//    fun updateUser(user: User) = viewModelScope.launch {
//        Log.i("body vm update", user.toString())
//        userUseCase.updateUserUseCase.invoke(user)
//        _userData.value = user
////        saveCurrentUser(user)
//    }
}