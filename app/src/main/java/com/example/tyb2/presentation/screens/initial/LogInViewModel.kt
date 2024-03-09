package com.example.tyb2.presentation.screens.initial

import androidx.lifecycle.ViewModel
import com.example.tyb2.domain.user.usecases.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LogInViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
) : ViewModel() {

}