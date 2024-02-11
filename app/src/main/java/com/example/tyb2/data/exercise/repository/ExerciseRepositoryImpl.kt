package com.example.tyb2.data.exercise.repository

import com.example.tyb2.data.user.AccountData
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.repository.ExerciseRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.GenericTypeIndicator
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class ExerciseRepositoryFirebaseImpl
@Inject constructor(databaseReference: DatabaseReference) : ExerciseRepository {
    private val exerciseDatabaseReference =
        databaseReference.child("${AccountData.ID}/exercise")

    override suspend fun getExercises(): List<Exercise>? {
        val dataSnapshot = exerciseDatabaseReference.get().await()

        val t: GenericTypeIndicator<List<Exercise>> =
            object :
                GenericTypeIndicator<List<Exercise>>() {}

        return dataSnapshot.getValue(t)

    }

    override suspend fun insertExercise(exercise: Exercise) {
        exerciseDatabaseReference.child(exercise.id).setValue(exercise)
    }

    override suspend fun deleteExercise(exercise: Exercise) {
        exerciseDatabaseReference.child(exercise.id).removeValue()
    }
}
