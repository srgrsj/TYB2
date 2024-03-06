package com.example.tyb2.presentation.screens.profile.achievements

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.data.user.AccountData
import com.example.tyb2.domain.user.usecases.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AchievementsViewModel @Inject constructor(
    private val userUseCase: UserUseCase,

    ) : ViewModel() {

}