package com.example.tyb2.domain.user.model

import java.util.UUID

data class User(
    val email: String,
    val id: String = UUID.randomUUID().toString(),
//    val username: String,
//    val profilePictureUrl: String?,
//    val categories:
//    val achievements
)

data class SignInResult(
    val user: User?,
    val errorMessage: String?
)