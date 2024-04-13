package com.example.tyb2.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.presentation.ui.theme.Typography


@Composable
fun ExerciseCard(exercise: Exercise, isExerciseInProgress: Boolean, onClick: (() -> Unit)? = {}) {
    val interactionSource = remember { MutableInteractionSource() }

    val durationOfOneCircle = exercise.durationOfOneCircle?.toInt() ?: 0


    val progress by animateFloatAsState(
        targetValue = if (isExerciseInProgress) 1f else 0f,
        label = "",
        animationSpec = tween(
            durationMillis = durationOfOneCircle,
            easing = LinearEasing
        )
    )

    val scaleY by animateDpAsState(
        targetValue = if (isExerciseInProgress) 100.dp else 0.dp,
        label = "",
        animationSpec = tween(
            durationMillis = 500,
        )
    )


    val scaleX by animateFloatAsState(
        targetValue = if (isExerciseInProgress) 0.93f else 0.9f,
        label = "",
        animationSpec = tween(
            durationMillis = 500
        )
    )

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
            modifier = Modifier
//                .height(62.dp + scaleY)
                .fillMaxWidth(scaleX)
//                .clickable { if (!isExerciseInProgress) isExerciseInProgress = true }
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) { onClick }


        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp)
                    .height(72.dp)
            ) {
                exercise.title?.let {
                    Text(
                        text = it,
                        style = Typography.labelMedium
                    )
                }


            }

            if (!exercise.description.isNullOrEmpty()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(scaleY)
                ) {

                    Text(
                        text = exercise.description.toString(),
                        style = Typography.labelSmall,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .padding(start = 5.dp, end = 5.dp)
                    )

                }
            }

//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(scaleY)
//            ) {
//
//
//                if (exercise.exerciseType == ExerciseType.TIME) {
//                    Box(
//                        contentAlignment = Alignment.Center,
//                        modifier = Modifier
//                            .height(72.dp)
//                            .width(72.dp)
//                    ) {
//
//                        CircularProgressIndicator(
//                            progress = progress,
//                            color = redColor,
//                            trackColor = MaterialTheme.colorScheme.onPrimary,
//                            strokeWidth = 10.dp,
//                            strokeCap = StrokeCap.Round,
//                            modifier = Modifier
//                                .height(52.dp)
//                                .width(52.dp)
//
//                        )
//
//                        Text(
//                            text = "%.0f%%".format(progress * 100),
//                            style = Typography.bodySmall
//
//                        )
//                    }
//                }
//
//                if (exercise.exerciseType == ExerciseType.REPETITION) {
//                    Text(
//                        text = stringResource(id = R.string.repetitions) + " " + exercise.numberOfRepetitions,
//                        style = Typography.bodyMedium,
//                        color = MaterialTheme.colorScheme.onPrimary
//                    )
//
//                    Text(
//                        text = stringResource(id = R.string.circles) + " " + exercise.numberOfRepetitions,
//                        style = Typography.bodyMedium,
//                        color = MaterialTheme.colorScheme.onPrimary,
//                        modifier = Modifier
//                            .padding(end = 10.dp)
//                    )
//                }
        }
    }
}
