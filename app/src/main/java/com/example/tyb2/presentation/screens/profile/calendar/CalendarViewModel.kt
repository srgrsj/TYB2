package com.example.tyb2.presentation.screens.profile.calendar

import androidx.lifecycle.ViewModel
import com.example.tyb2.domain.user.usecases.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val userUseCase: UserUseCase,

    ) : ViewModel() {

}