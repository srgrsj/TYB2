package com.example.tyb2.domain.app.repository

import com.example.tyb2.domain.workout.model.Workout
import kotlinx.coroutines.flow.StateFlow

interface AppRepository {

    val currentWorkout: StateFlow<Workout?>

    suspend fun setCurrentWorkout(workout: Workout?)
}