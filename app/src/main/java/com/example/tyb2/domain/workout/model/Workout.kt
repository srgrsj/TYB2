package com.example.tyb2.domain.workout.model

import android.os.Parcelable
import com.example.tyb2.domain.exersice.model.Exercise
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Workout(
    var title: String? = "",
    var description: String? = "",
    var duration: Long? = null,
    var isInFav: Boolean? = false,
    var workoutGenerationType: WorkoutGenerationType = WorkoutGenerationType.USER,
    var exerciseList: List<Exercise> = listOf(),
    val id: String? = UUID.randomUUID().toString()
): Parcelable

enum class WorkoutGenerationType {
    AUTHOR, USER, GPT
}
