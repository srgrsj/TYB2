package com.example.tyb2.presentation.components.workoutCards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tyb2.R
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.presentation.screens.main.WorkoutsViewModel
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.util.DateTimeUtils
import com.example.tyb2.util.Muscle
import com.example.tyb2.util.MuscleStuff

@Preview
@Composable
fun TestShedevroCard(
) {
    WorkoutCard(
        workout = Workout(
            "Workout",
            "some description",
            4365273,
            listOf(Muscle.LEG_QUADRICEPS, Muscle.BRACHIAL_FRONT, Muscle.BREAST),
            false,
            exerciseList = listOf(
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
    workout: Workout,
    viewModel: WorkoutsViewModel = hiltViewModel(),
    navigateToWorkoutPreviewScreen: ((Workout) -> Unit)? = null
) {

    val muscleList = workout.muscles!!.toMutableSet()

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
                    painter = painterResource(id = R.drawable.muscles_thoracic),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 30.dp, start = 5.dp)
                        .scale(1.5f)
                )


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

                    Spacer(modifier = Modifier.width(20.dp))

                    muscleList.forEach {
                        Box(
                            modifier = Modifier
                                .padding(
                                    top = 4.dp,
                                    start = 4.dp
                                )
                                .clip(RoundedCornerShape(10.dp))
                                .background(MuscleStuff.defineColor(MuscleStuff.defineGroup(it)))
                                .height(15.dp)
                                .width(15.dp)
                        )

                        Text(
                            text = MuscleStuff.defineTitle(MuscleStuff.defineGroup(it)),
                            style = Typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .padding(
                                    top = 4.dp,
                                    start = 4.dp
                                )
                        )
                    }
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