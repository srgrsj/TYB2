package com.example.tyb2.presentation.screens.profile.profile_settings

import androidx.lifecycle.ViewModel
import com.example.tyb2.domain.user.usecases.UserUseCase
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileSettingsViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
    private val workoutUseCase: WorkoutUseCase,
) : ViewModel() {
// TODO

}