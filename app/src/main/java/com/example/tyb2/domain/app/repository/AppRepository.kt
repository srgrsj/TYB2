package com.example.tyb2.domain.app.repository

import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.workout.model.Workout
import kotlinx.coroutines.flow.StateFlow

interface AppRepository {
    val currentWorkout: StateFlow<Workout?>
    val currentUser: StateFlow<User?>
    suspend fun setCurrentWorkout(workout: Workout?)
    suspend fun setCurrentUser(user: User?)
}