package com.example.tyb2.presentation.screens.initial.auth.signIn

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tyb2.data.user.AccountData
import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.user.usecases.UserUseCase
import com.example.tyb2.presentation.screens.initial.auth.GoogleSignInState
import com.example.tyb2.presentation.screens.initial.auth.SignInState
import com.example.tyb2.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
) : ViewModel() {
    private val _signInState = Channel<SignInState>()
    val signInState = _signInState.receiveAsFlow()

    private val _googleSignInState = mutableStateOf(GoogleSignInState())
    val googleSignInState: State<GoogleSignInState> = _googleSignInState

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        userUseCase.userSignInUseCase(email, password).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _signInState.send(SignInState(isSuccess = "Sign In Success"))
                }

                is Resource.Loading -> {
                    _signInState.send(SignInState(isLoading = true))
                }

                is Resource.Error -> {
                    _signInState.send(SignInState(isError = result.message.toString()))
                }
            }
        }
        AccountData.ID = Firebase.auth.currentUser?.uid
        AccountData.EMAIL = Firebase.auth.currentUser?.email
    }

    fun continueWithFirebase(credential: AuthCredential) = viewModelScope.launch {
        userUseCase.continueWithGoogleUseCase(credential).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _googleSignInState.value = GoogleSignInState(success = result.data)
                }

                is Resource.Loading -> {
                    _googleSignInState.value = GoogleSignInState(loading = true)
                }

                is Resource.Error -> {
                    _googleSignInState.value = GoogleSignInState(error = result.message ?: "")
                }
            }
        }
        AccountData.ID = Firebase.auth.currentUser?.uid
        AccountData.EMAIL = Firebase.auth.currentUser?.email
        userUseCase.addUserUseCase.invoke(
            User(
                id = AccountData.ID.toString(),
                email = AccountData.EMAIL.toString()
            )
        )
    }

    fun getCurrentUser() = viewModelScope.launch {
        userUseCase.getSignedInUserUseCase.invoke()
    }
}