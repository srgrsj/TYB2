package com.example.tyb2.di

import android.app.Application
import android.content.Context
import com.example.tyb2.app.TYB2App
import com.example.tyb2.data.user.repository.UserRepositoryFirebaseImpl
import com.example.tyb2.domain.user.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
        application: Application,
        firebaseAuth: FirebaseAuth,
        databaseReference: DatabaseReference
    ): UserRepository {
        return UserRepositoryFirebaseImpl(application, firebaseAuth, databaseReference)
    }

    @Provides
    fun provideContext(@ApplicationContext appContext: Context): Context = appContext
}