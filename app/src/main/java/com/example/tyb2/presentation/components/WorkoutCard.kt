package com.example.tyb2.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tyb2.R
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.model.WorkoutGenerationType
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.util.DateTimeUtils

@Preview
@Composable
fun TestShedevroCard() {
    WorkoutCard(
        workout = Workout(
            "Workout",
            "some description",
            4365273,
            false,
            WorkoutGenerationType.USER,
            listOf(
                Exercise(
                    "Exercise1",
                    "some description",
                    52,
                    52,
                    15,
                    15,
                    ExerciseType.REPETITION,
                ),
                Exercise(
                    "Exercise2",
                    "some description",
                    52,
                    52,
                    15,
                    15,
                    ExerciseType.REPETITION,
                ),
                Exercise(
                    "Exercise2",
                    "some description",
                    52,
                    52,
                    15,
                    15,
                    ExerciseType.REPETITION,
                )
            )
        )
    )
}


@Composable
fun WorkoutCard(
    workout: Workout
) {

    Card(
        modifier = Modifier
            .width(360.dp)
            .height(96.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Box(
                modifier = Modifier
                    .clip(
                        shape = MaterialTheme.shapes.medium.copy(
                            topStart = CornerSize(0.dp),
                            bottomStart = CornerSize(0.dp),
                            topEnd = CornerSize(10.dp),
                            bottomEnd = CornerSize(10.dp)
                        )
                    )
                    .height(96.dp)
                    .width(96.dp)
                    .background(MaterialTheme.colorScheme.onPrimary)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.muscle),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(
                            top = 15.dp
                        )
                )

//                Image(
//                    painter = painterResource(id = R.drawable.breast),
//                    contentDescription = "",
//                    modifier = Modifier
//                        .scale(4.5f)
//                        .padding(
//                            top = 20.dp,
//                            start = 8.dp
//                        )
//                )


                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .height(2.dp)
                            .width(64.dp)
                            .clip(
                                shape = MaterialTheme.shapes.medium.copy(
                                    topStart = CornerSize(2.dp),
                                    bottomStart = CornerSize(2.dp),
                                    topEnd = CornerSize(0.dp),
                                    bottomEnd = CornerSize(0.dp)
                                )
                            )
                            .background(MaterialTheme.colorScheme.primary)
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 6.dp)
                            .height(2.dp)
                            .width(48.dp)
                            .clip(
                                shape = MaterialTheme.shapes.medium.copy(
                                    topStart = CornerSize(2.dp),
                                    bottomStart = CornerSize(2.dp),
                                    topEnd = CornerSize(0.dp),
                                    bottomEnd = CornerSize(0.dp)
                                )
                            )
                            .background(MaterialTheme.colorScheme.primary)
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 6.dp)
                            .height(2.dp)
                            .width(32.dp)
                            .clip(
                                shape = MaterialTheme.shapes.medium.copy(
                                    topStart = CornerSize(2.dp),
                                    bottomStart = CornerSize(2.dp),
                                    topEnd = CornerSize(0.dp),
                                    bottomEnd = CornerSize(0.dp)
                                )
                            )
                            .background(MaterialTheme.colorScheme.primary)

                    )
                }
            }

            Column {
                workout.title?.let {
                    Text(
                        text = it,
                        style = Typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .padding(
                                top = 4.dp,
                                start = 24.dp
                            )
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {

                    Box(
                        modifier = Modifier
                            .padding(
                                top = 4.dp,
                                start = 24.dp
                            )
                            .clip(RoundedCornerShape(10.dp))
                            .background(redColor)
                            .height(15.dp)
                            .width(15.dp)


                    )

                    Text(
                        text = "Breast",
                        style = Typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .padding(
                                top = 4.dp,
                                start = 4.dp
                            )
                    )
                }

                Text(
                    text = stringResource(id = R.string.desired_duration) + " " + workout.duration?.let {
                        DateTimeUtils.formatDuration(
                            it
                        )
                    },
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = Typography.bodySmall,
                    modifier = Modifier
                        .padding(
                            top = 4.dp,
                            start = 24.dp
                        )
                )

            }
        }
    }
}