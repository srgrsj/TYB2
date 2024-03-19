package com.example.tyb2.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.util.DateTimeUtils
import com.example.tyb2.util.Muscle
import com.example.tyb2.util.MuscleGroup
import com.example.tyb2.util.MuscleStuff


@Preview
@Composable
fun TimeExercisePreview() {
    ExercisePreview(
        exercise = Exercise(
            title = "Test",
            numberOfCircles = 3,
            durationOfRest = 1000,
            durationOfOneCircle = 1000,
            exerciseType = ExerciseType.TIME,
            muscleList = listOf(Muscle.LEG_QUADRICEPS, Muscle.ARM_TRICEPS)
        )
    )
}

@Preview
@Composable
fun RepetitionExercisePreview() {
    ExercisePreview(
        exercise = Exercise(
            title = "Test",
            numberOfRepetitions = 3,
            numberOfCircles = 4,
            exerciseType = ExerciseType.REPETITION,
            muscleList = listOf(Muscle.LEG_QUADRICEPS, Muscle.ARM_TRICEPS)
        )
    )
}


@Composable
fun ExercisePreview(exercise: Exercise) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    val scaleY by animateDpAsState(
        targetValue = if (isExpanded) 48.dp else 0.dp,
        label = "",
        animationSpec = tween(
            durationMillis = 500,
        )
    )

    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                isExpanded = !isExpanded
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
//                .fillMaxWidth()
                .height(62.dp)
                .padding(start = 20.dp)
        ) {
            exercise.title?.let {
                Text(
                    text = it,
                    style = Typography.labelMedium
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                val muscleGroupList = mutableSetOf<MuscleGroup>()

                exercise.muscleList?.forEach {
                    muscleGroupList.add(MuscleStuff.defineGroup(it))
                }

                muscleGroupList.forEach() {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(MuscleStuff.defineColor(it))
                    ) {

                    }
                }
            }

        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .height(scaleY)
                .padding(start = 20.dp)
        ) {
            when (exercise.exerciseType) {
                ExerciseType.REPETITION -> {
                    Text(
                        text = "Circles: " + exercise.numberOfCircles.toString(),
                        style = Typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )

                    Text(
                        text = "Repetitions: " + exercise.numberOfCircles.toString(),
                        style = Typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }

                ExerciseType.TIME -> {
                    Text(
                        text = "Circles: " + exercise.numberOfCircles.toString(),
                        style = Typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Text(
                        text = "Work: " + exercise.durationOfOneCircle?.let {
                            DateTimeUtils.formatDuration(
                                it
                            )
                        },
                        style = Typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Text(
                        text = "Rest: " + exercise.durationOfRest?.let {
                            DateTimeUtils.formatDuration(
                                it
                            )
                        },
                        style = Typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }

                else -> {}
            }
        }

    }

}