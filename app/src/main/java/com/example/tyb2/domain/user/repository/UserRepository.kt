package com.example.tyb2.domain.user.repository

import com.example.tyb2.domain.user.model.User
import com.example.tyb2.util.Resource
import com.google.firebase.auth.AuthResult

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUser(user: User)
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun singOutUser()
}