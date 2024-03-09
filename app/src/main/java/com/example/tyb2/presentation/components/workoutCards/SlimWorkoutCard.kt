package com.example.tyb2.presentation.components.workoutCards


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tyb2.R
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.model.WorkoutGenerationType
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.presentation.ui.theme.redColor

@Preview
@Composable
fun TestShedevroCardSlim() {
    SlimWorkoutCard(
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
fun SlimWorkoutCard(
    workout: Workout
) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(80.dp)
            .border(2.dp, redColor, RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Box(
                contentAlignment = Alignment.BottomStart,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
                    .background(redColor)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(0.8f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.onPrimary)
                ) {
                    Box(
                        contentAlignment = Alignment.TopStart,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .clip(CircleShape)
                                .height(4.dp)
                                .width(60.dp)
                                .background(MaterialTheme.colorScheme.primary)
                        ) {}

                        Box(
                            modifier = Modifier
                                .padding(top = 22.dp)
                                .clip(CircleShape)
                                .height(4.dp)
                                .width(40.dp)
                                .background(MaterialTheme.colorScheme.primary)
                        ) {}

                        Box(
                            modifier = Modifier
                                .padding(top = 34.dp)
                                .clip(CircleShape)
                                .height(4.dp)
                                .width(20.dp)
                                .background(MaterialTheme.colorScheme.primary)
                        ) {}
                    }

                    Box(
                        contentAlignment = Alignment.BottomCenter,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.muscles_thoracic),
                            contentDescription = null,
                            modifier = Modifier
//                                .scale(1.8f)
//                                .padding(bottom = 2.dp)
                        )
                    }

                }

                Box(
                    modifier = Modifier
                        .padding(bottom = 2.dp, start = 2.dp)
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.onPrimary,
                            RoundedCornerShape(10.dp)
                        )
                        .fillMaxSize(0.87f)
                ) {}

                Box(
                    modifier = Modifier
                        .padding(bottom = 2.dp, start = 2.dp)
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.onPrimary,
                            RoundedCornerShape(10.dp)
                        )
                        .fillMaxSize(0.95f)
                ) {}
            }

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 5.dp, start = 2.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
//                        .fillMaxHeight(0.6f)
                        ) {
                            Text(
                                text = workout.title!!,
                                style = Typography.bodyMedium.copy(fontWeight = FontWeight.ExtraBold),
                                color = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier
                                    .padding(start = 5.dp)
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .height(10.dp)
                                    .width(10.dp)
                                    .clip(CircleShape)
                                    .background(redColor)
                            ) {}

                            Text(
                                text = "Грудь",
                                color = MaterialTheme.colorScheme.onPrimary,
                                style = Typography.bodySmall,
                                modifier = Modifier
                                    .padding(start = 5.dp)
                            )
                        }
                    }
                }

                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    Icon(
                        painter = painterResource(
                            id = if (workout.isInFav == false) R.drawable.icon_save_outlined else R.drawable.icon_save_field
                        ),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .scale(0.7f)
                            .padding(end = 5.dp,  bottom = 5.dp)
                    )
                }

            }


        }
    }
}