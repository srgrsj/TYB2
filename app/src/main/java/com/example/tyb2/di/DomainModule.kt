package com.example.tyb2.di

import com.example.tyb2.data.exercise.repository.ExerciseRepositoryFirebaseImpl
import com.example.tyb2.data.user.repository.UserRepositoryFirebaseImpl
import com.example.tyb2.data.workout.repository.WorkoutRepositoryFirebaseImpl
import com.example.tyb2.domain.exercise.usecase.AddExerciseUseCase
import com.example.tyb2.domain.exercise.usecase.DeleteExerciseUseCase
import com.example.tyb2.domain.exercise.usecase.ExerciseUseCase
import com.example.tyb2.domain.exercise.usecase.GetExercisesUseCase
import com.example.tyb2.domain.user.usecases.AddUserUseCase
import com.example.tyb2.domain.user.usecases.ReadOnboardingIsShow
import com.example.tyb2.domain.user.usecases.SaveOnboardingIsShow
import com.example.tyb2.domain.user.usecases.UserSignInUseCase
import com.example.tyb2.domain.user.usecases.UserSignOutUseCase
import com.example.tyb2.domain.user.usecases.UserSignUpUseCase
import com.example.tyb2.domain.user.usecases.UserUseCase
import com.example.tyb2.domain.workout.usecases.AddWorkoutUseCase
import com.example.tyb2.domain.workout.usecases.ChangeWorkoutFavState
import com.example.tyb2.domain.workout.usecases.DeleteWorkoutUseCase
import com.example.tyb2.domain.workout.usecases.GetWorkoutsUseCase
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun providesExerciseUseCases(exerciseRepositoryFirebaseImpl: ExerciseRepositoryFirebaseImpl): ExerciseUseCase =
        ExerciseUseCase(
            addExerciseUseCase = AddExerciseUseCase(exerciseRepositoryFirebaseImpl),
            getExercisesUseCase = GetExercisesUseCase(exerciseRepositoryFirebaseImpl),
            deleteExerciseUseCase = DeleteExerciseUseCase(exerciseRepositoryFirebaseImpl)
        )

    @Provides
    fun providesWorkoutUseCases(workoutRepositoryFirebaseImpl: WorkoutRepositoryFirebaseImpl): WorkoutUseCase =
        WorkoutUseCase(
            addWorkoutUseCase = AddWorkoutUseCase(workoutRepositoryFirebaseImpl),
            getWorkoutsUseCase = GetWorkoutsUseCase(workoutRepositoryFirebaseImpl),
            deleteWorkoutUseCase = DeleteWorkoutUseCase(workoutRepositoryFirebaseImpl),
            changeWorkoutFavState = ChangeWorkoutFavState(workoutRepositoryFirebaseImpl)
        )

    @Provides
    fun providesUserUseCases(userRepositoryFirebaseImpl: UserRepositoryFirebaseImpl): UserUseCase =
        UserUseCase(
            addUserUseCase = AddUserUseCase(userRepositoryFirebaseImpl),
            userSignInUseCase = UserSignInUseCase(userRepositoryFirebaseImpl),
            userSignOutUseCase = UserSignOutUseCase(userRepositoryFirebaseImpl),
            userSignUpUseCase = UserSignUpUseCase(userRepositoryFirebaseImpl),
            readOnboardingIsShow = ReadOnboardingIsShow(userRepositoryFirebaseImpl),
            saveOnboardingIsShow = SaveOnboardingIsShow(userRepositoryFirebaseImpl)
        )
}