package com.example.tyb2.domain.workout.readyWorkoutsData

import android.content.Context
import com.example.tyb2.R
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.domain.exersice.readyExercisesData.ReadyExercises
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.model.WorkoutSource
import com.example.tyb2.util.Muscle

enum class ReadyWorkouts(val workout: Workout) {
    WorkoutForBeginner(
        Workout(
            workoutGenerationType = WorkoutSource.AUTHOR
        )
    ),
    WorkoutForIntermediate(
        Workout(
            workoutGenerationType = WorkoutSource.AUTHOR
        )
    ),
    WorkoutForPro(
        Workout(
            workoutGenerationType = WorkoutSource.AUTHOR
        )
    );

    fun getLocalizedWorkout(context: Context): Workout {
        when (this) {
            WorkoutForBeginner -> return this.workout.copy(
                title = context.getString(R.string.beginners_workout),
                description = context.getString(R.string.beginners_workout_description),
                duration = 30 * 1000 * 60,
                muscles = listOf(Muscle.ARM_BICEPS, Muscle.BACK_WIDE), //TODO
                exerciseList = listOf(
                    ReadyExercises.PUSH_UPS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 12,
                        numberOfCircles = 2,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    ),
                    ReadyExercises.SQUATS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 12,
                        numberOfCircles = 2,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    ),
                    ReadyExercises.PLANK.getLocalizedExercise(context).copy(
                        durationOfOneCircle = 30 * 1000,
                        numberOfCircles = 2,
                        exerciseType = ExerciseType.TIME,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    ),
                    ReadyExercises.PULL_UPS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 5,
                        numberOfCircles = 2,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    )
                )
            )

            WorkoutForIntermediate -> return this.workout.copy(
                title = context.getString(R.string.intermediate_workout),
                description = context.getString(R.string.intermediate_workout_description),
                duration = 45 * 1000 * 60,
                muscles = listOf(Muscle.BREAST, Muscle.BRACHIAL_FRONT), //TODO
                exerciseList = listOf(
                    ReadyExercises.DUMBBELL_PRESS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 8,
                        numberOfCircles = 3,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    ),
                    ReadyExercises.DUMBBELL_LATERAL_RAISES.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 10,
                        numberOfCircles = 3,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    ),
                    ReadyExercises.BENT_OVER_DUMBBELL_ROWS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 12,
                        numberOfCircles = 3,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    ),
                    ReadyExercises.DUMBBELL_BICEP_CURLS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 10,
                        numberOfCircles = 3,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    ),
                    ReadyExercises.REGULAR_CRUNCH.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 15,
                        numberOfCircles = 3,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    )
                )
            )

            WorkoutForPro -> return this.workout.copy(
                title = context.getString(R.string.experienced_workout),
                description = context.getString(R.string.experienced_workout_description),
                duration = 60 * 1000 * 60,
                muscles = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT), //TODO
                exerciseList = listOf(
                    ReadyExercises.DIPS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 12,
                        numberOfCircles = 4,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    ),
                    ReadyExercises.LUNGES.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 10,
                        numberOfCircles = 4,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    ),
                    ReadyExercises.HYPEREXTENSION.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 12,
                        numberOfCircles = 4,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    ),
                    ReadyExercises.LEG_RAISES.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 8,
                        numberOfCircles = 4,
                        exerciseType = ExerciseType.REPETITION,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    ),
                    ReadyExercises.PLANK_WITH_SHOULDER_TAPS.getLocalizedExercise(context).copy(
                        durationOfOneCircle = 30 * 1000,
                        numberOfCircles = 4,
                        exerciseType = ExerciseType.TIME,
                        muscleList = listOf(Muscle.LEG_CALF, Muscle.CORE_STRAIGHT)
                    )
                )
            )
        }
    }
}
