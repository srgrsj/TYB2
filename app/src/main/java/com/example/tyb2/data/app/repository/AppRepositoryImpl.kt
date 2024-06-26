package com.example.tyb2.data.app.repository

import com.example.tyb2.R
import com.example.tyb2.domain.app.repository.AppRepository
import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.workout.model.Workout
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class AppRepositoryImpl @Inject constructor() : AppRepository {
    companion object {
        private val _currentWorkout = MutableStateFlow<Workout?>(null)
        private val _currentUser = MutableStateFlow<User?>(null)
    }

    override val currentWorkout: StateFlow<Workout?>
        get() = _currentWorkout
    override val currentUser: StateFlow<User?>
        get() = _currentUser

    override suspend fun setCurrentWorkout(workout: Workout?) {
        _currentWorkout.emit(workout)
    }
    override suspend fun setCurrentUser(user: User?) {
        _currentUser.emit(user)
    }
}