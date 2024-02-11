package com.example.tyb2.di

import com.example.tyb2.data.user.repository.UserRepositoryFirebaseImpl
import com.example.tyb2.domain.user.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesRepositoryImpl(
        firebaseAuth: FirebaseAuth,
        databaseReference: DatabaseReference
    ): UserRepository {
        return UserRepositoryFirebaseImpl(firebaseAuth, databaseReference)
    }
}