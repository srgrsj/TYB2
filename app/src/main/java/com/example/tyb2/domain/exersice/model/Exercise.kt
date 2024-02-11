package com.example.tyb2.domain.exersice.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Exercise(
    var title: String? = "",
    var description: String? = "",
    var numberOfRepetitions: Int? = null,
    var numberOfCircles: Int? = null,
    var durationOfOneCircle: Long? = null,
    var durationOfRest: Long? = null,
    var exerciseType: ExerciseType? = null,
    var demonstration: String? = null,
    val id: String = UUID.randomUUID().toString()
) : Parcelable

enum class ExerciseType {
    TIME, REPETITION
}
