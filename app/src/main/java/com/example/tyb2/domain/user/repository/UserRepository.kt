package com.example.tyb2.domain.user.repository

import com.example.tyb2.domain.user.model.AchievementType
import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUser(user: User)
//    suspend fun updateProfilePicture(id: String, profilePicValue: String) //Updating the picture according to gender
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun singOutUser()
    suspend fun saveOnboardingIsShow()
    fun readOnboardingIsShow(): Flow<Boolean>
    suspend fun continueWithGoogle(credential: AuthCredential): Flow<Resource<AuthResult>>
    suspend fun getSignedInUser(): User?
    fun updateAchievement(user:User, achievementType: AchievementType)
    suspend fun updateUser(user: User)
    fun getUserAvatar() : Flow<String>
    suspend fun setUserAvatar(value: String)
}