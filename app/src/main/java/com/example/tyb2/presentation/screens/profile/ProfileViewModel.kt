package com.example.tyb2.presentation.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.data.user.AccountData
import com.example.tyb2.domain.user.usecases.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {
    fun singOutUser() = viewModelScope.launch {
        userUseCase.userSignOutUseCase()

        AccountData.EMAIL = null
        AccountData.ID = null
    }

    fun getUserPicture() {
        userUseCase.getSignedInUserUseCase.invoke()
    }
}