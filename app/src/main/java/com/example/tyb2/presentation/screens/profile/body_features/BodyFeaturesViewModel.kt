package com.example.tyb2.presentation.screens.profile.body_features

import androidx.lifecycle.ViewModel
import com.example.tyb2.domain.user.usecases.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BodyFeaturesViewModel @Inject constructor(
    private val userUseCase: UserUseCase,

    ) : ViewModel() {

}