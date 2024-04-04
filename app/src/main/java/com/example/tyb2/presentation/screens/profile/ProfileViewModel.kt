package com.example.tyb2.presentation.screens.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.R
import com.example.tyb2.data.user.AccountData
import com.example.tyb2.domain.app.usecase.AppUseCases
import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.user.usecases.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val appUseCases: AppUseCases,
    private val userUseCase: UserUseCase,
) : ViewModel() {

    private val _userData = MutableStateFlow<User?>(null)
    val userData: StateFlow<User?> = _userData

    fun singOutUser() = viewModelScope.launch {
        userUseCase.userSignOutUseCase()

        AccountData.EMAIL = null
        AccountData.ID = null
    }

    fun getUserPicture() {
        userUseCase.getSignedInUserUseCase.invoke()
    }

    fun getUserData(): User? = userUseCase.getSignedInUserUseCase.invoke()


    fun getUserAvatar(gender: Boolean?): Int {
        return when (gender) {
            null -> R.drawable.profile_avatar_default
            true -> R.drawable.profile_avatar_man
            else -> R.drawable.profile_avatar_woman
        }
    }

    fun updateUser(user: User) = viewModelScope.launch {
        Log.i("test view model", user.toString())
        userUseCase.updateUserUseCase.invoke(user)
        _userData.value = user
    }

    fun setAvatar() = viewModelScope.launch {
        appUseCases.setAvatarUseCase.invoke(getUserAvatar(getUserData()?.userGenderIsMan))
    }
}