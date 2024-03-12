package com.example.tyb2.domain.workout.model

import android.os.Parcelable
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.util.Muscle
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Workout(
    var title: String? = "",
    var description: String? = "",
    var duration: Long? = null,
    var muscles: List<Muscle>? = listOf(),
    var isInFav: Boolean? = false,
    var workoutGenerationType: WorkoutSource? = WorkoutSource.USER,
    var exerciseList: List<Exercise>? = listOf(),
    val id: String? = UUID.randomUUID().toString()
): Parcelable

enum class WorkoutSource {
    AUTHOR, USER, GPT
}


