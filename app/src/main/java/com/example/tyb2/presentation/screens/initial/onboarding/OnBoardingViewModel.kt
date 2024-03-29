package com.example.tyb2.presentation.screens.initial.onboarding

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.data.user.repository.TYBDatastore
import com.example.tyb2.domain.user.usecases.UserUseCase
import com.example.tyb2.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
//    private val context: Context
): ViewModel() {

    var startDestination by mutableStateOf(Screen.ONBOARDING)
        private set

    val onboardingIsShow = userUseCase.readOnboardingIsShow
    init {
//        context.TYBDatastore.
//        tybDataStore.readAppEntry.onEach {
//            startDestination = if (it)
//                Screen.OnBoardingScreen.name else
//                Screen.HomeScreen.name
//            delay(300)
//        }.launchIn(viewModelScope)
    }

    private fun saveOnboardingIsShow() {
        viewModelScope.launch {
            userUseCase.saveOnboardingIsShow()
        }
    }
}