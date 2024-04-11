package com.example.tyb2.domain.workout.readyYogaData

import android.content.Context
import com.example.tyb2.R
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.domain.exersice.readyExercisesData.ReadyExercises
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.model.WorkoutSource

enum class ReadyYoga(val workout: Workout) {
    YogaForBeginner(
        Workout(
            workoutGenerationType = WorkoutSource.AUTHOR
        )
    ),
    YogaForIntermediate(
        Workout(
            workoutGenerationType = WorkoutSource.AUTHOR
        )
    ),
    YogaForPro(
        Workout(
            workoutGenerationType = WorkoutSource.AUTHOR
        )
    );

    fun getLocalizedYoga(context: Context): Workout {
        when (this) {
            YogaForBeginner -> return this.workout.copy(
                title = context.getString(R.string.beginners_yoga),
                description = context.getString(R.string.beginners_yoga_description),
                duration = 30 * 1000 * 60,
                exerciseList = listOf(
                    ReadyExercises.PUSH_UPS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 12,
                        numberOfCircles = 2,
                        exerciseType = ExerciseType.REPETITION
                    ),
                    ReadyExercises.SQUATS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 12,
                        numberOfCircles = 2,
                        exerciseType = ExerciseType.REPETITION
                    ),
                    ReadyExercises.PLANK.getLocalizedExercise(context).copy(
                        durationOfOneCircle = 30 * 1000,
                        numberOfCircles = 2,
                        exerciseType = ExerciseType.TIME
                    ),
                    ReadyExercises.PULL_UPS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 5,
                        numberOfCircles = 2,
                        exerciseType = ExerciseType.REPETITION
                    )
                )
            )
            YogaForIntermediate -> return this.workout.copy(
                title = context.getString(R.string.intermediate_yoga),
                description = context.getString(R.string.intermediate_yoga_description),
                duration = 45 * 1000 * 60,
                exerciseList = listOf(
                    ReadyExercises.DUMBBELL_PRESS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 8,
                        numberOfCircles = 3,
                        exerciseType = ExerciseType.REPETITION
                    ),
                    ReadyExercises.DUMBBELL_LATERAL_RAISES.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 10,
                        numberOfCircles = 3,
                        exerciseType = ExerciseType.REPETITION
                    ),
                    ReadyExercises.BENT_OVER_DUMBBELL_ROWS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 12,
                        numberOfCircles = 3,
                        exerciseType = ExerciseType.REPETITION
                    ),
                    ReadyExercises.DUMBBELL_BICEP_CURLS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 10,
                        numberOfCircles = 3,
                        exerciseType = ExerciseType.REPETITION
                    ),
                    ReadyExercises.REGULAR_CRUNCH.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 15,
                        numberOfCircles = 3,
                        exerciseType = ExerciseType.REPETITION
                    )
                )
            )
            YogaForPro -> return this.workout.copy(
                title = context.getString(R.string.experienced_yoga),
                description = context.getString(R.string.experienced_yoga_description),
                duration = 60 * 1000 * 60,
                exerciseList = listOf(
                    ReadyExercises.DIPS.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 12,
                        numberOfCircles = 4,
                        exerciseType = ExerciseType.REPETITION
                    ),
                    ReadyExercises.LUNGES.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 10,
                        numberOfCircles = 4,
                        exerciseType = ExerciseType.REPETITION
                    ),
                    ReadyExercises.HYPEREXTENSION.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 12,
                        numberOfCircles = 4,
                        exerciseType = ExerciseType.REPETITION
                    ),
                    ReadyExercises.LEG_RAISES.getLocalizedExercise(context).copy(
                        numberOfRepetitions = 8,
                        numberOfCircles = 4,
                        exerciseType = ExerciseType.REPETITION
                    ),
                    ReadyExercises.PLANK_WITH_SHOULDER_TAPS.getLocalizedExercise(context).copy(
                        durationOfOneCircle = 30 * 1000,
                        numberOfCircles = 4,
                        exerciseType = ExerciseType.TIME
                    )
                )
            )
        }
    }
}
//var title: String? = "",
//var description: String? = "",
//var duration: Long? = null,
//var muscles: List<Muscle>? = listOf(),
//var isInFav: Boolean? = false,
//var workoutGenerationType: WorkoutSource? = WorkoutSource.USER,
//var exerciseList: List<Exercise>? = listOf(),
//val id: String? = UUID.randomUUID().toString()

val listOfYoga = listOf(
    Workout(
        title = "Доброе утро",
        description = "Упражнения, которые идеально подходят для пробуждения",
        duration = 10*60 + 5*60 + 3*60,
        exerciseList = listOf(
            TODO()
        ),
        workoutGenerationType = WorkoutSource.AUTHOR
    ),
    Workout(
        title = "Спокойствие",
        description = "Идеально снимает стресс",
        duration = (5 + 7 + 15) * 60,
        exerciseList = listOf(
            TODO()
        ),
        workoutGenerationType = WorkoutSource.AUTHOR
    ),
    Workout(
        title = "Сила и гибкость",
        description = "Упражнения, ",
        duration = 10*60 + 5*60 + 3*60,
        exerciseList = listOf(
            TODO()
        ),
        workoutGenerationType = WorkoutSource.AUTHOR
    ),
    Workout(
        title = "Доброе утро",
        description = "Упражнения, которые идеально подходят для пробуждения",
        duration = 10*60 + 5*60 + 3*60,
        exerciseList = listOf(
            TODO()
        ),
        workoutGenerationType = WorkoutSource.AUTHOR
    ),
    Workout(
        title = "Доброе утро",
        description = "Упражнения, которые идеально подходят для пробуждения",
        duration = 10*60 + 5*60 + 3*60,
        exerciseList = listOf(
            TODO()
        ),
        workoutGenerationType = WorkoutSource.AUTHOR
    ),
    Workout(
        title = "Доброе утро",
        description = "Упражнения, которые идеально подходят для пробуждения",
        duration = 10*60 + 5*60 + 3*60,
        exerciseList = listOf(
            TODO()
        ),
        workoutGenerationType = WorkoutSource.AUTHOR
    )
)