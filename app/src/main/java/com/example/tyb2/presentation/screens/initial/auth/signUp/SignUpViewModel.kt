package com.example.tyb2.presentation.screens.initial.auth.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.data.user.AccountData
import com.example.tyb2.domain.user.usecases.UserUseCase
import com.example.tyb2.presentation.screens.initial.auth.SignInState
import com.example.tyb2.util.Resource
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
) : ViewModel() {
    private val _signUpState = Channel<SignInState>()
    val signUpState = _signUpState.receiveAsFlow()
    fun signUpUser(email: String, password: String) = viewModelScope.launch {
        userUseCase.userSignInUseCase(email, password).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _signUpState.send(SignInState(isSuccess = "Sign In Success"))
                }

                is Resource.Loading -> {
                    _signUpState.send(SignInState(isLoading = true))
                }

                is Resource.Error -> {
                    _signUpState.send(SignInState(isError = result.message.toString()))
                }
            }

        }
        AccountData.ID = Firebase.auth.currentUser?.uid
        AccountData.EMAIL = Firebase.auth.currentUser?.email
    }
}