package com.example.tyb2.presentation.screens.initial.auth

import androidx.compose.runtime.MutableState
import com.google.firebase.auth.AuthResult

data class SignInState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)

data class GoogleSignInState(
    val success: AuthResult? = null,
    val loading: Boolean = false,
    val error: String? = ""
)