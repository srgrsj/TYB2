package com.example.tyb2.domain.app.repository

import com.example.tyb2.domain.workout.model.Workout
import kotlinx.coroutines.flow.StateFlow

interface AppRepository {
    val currentWorkout: StateFlow<Workout?>
    val currentAvatar: StateFlow<Int>
    suspend fun setCurrentWorkout(workout: Workout?)
    suspend fun setAvatar(avatar: Int)
}