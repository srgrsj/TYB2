package com.example.tyb2.presentation.screens.main.workoutpPlayback

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.tyb2.R
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.presentation.components.ExerciseCard
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.presentation.ui.theme.redColor

@Composable
fun WorkoutPlayback(
    navController: NavController, viewModel: WorkoutPlaybackViewModel = hiltViewModel()
) {
    val workout by viewModel.currentWorkout.collectAsStateWithLifecycle()
    val exerciseList = workout?.exerciseList
    val currentExerciseIndex by remember {
        mutableIntStateOf(0)
    }
    val currentExercise = exerciseList?.get(currentExerciseIndex)

    var isOnPause by remember {
        mutableStateOf(true)
    }
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        Box {
            Row(
//                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(top = 10.dp)

            ) {
                Text(
                    text = workout?.title ?: "",
                    style = Typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .scale(2f)
                        .padding(start = 5.dp)
                        .clickable {
                            navController.popBackStack()
                        })
            }
        }

        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.7f)
                    .background(MaterialTheme.colorScheme.onPrimary)
            ) {
                Box(
                    contentAlignment = Alignment.TopEnd, modifier = Modifier.fillMaxSize()
                ) {
                    AnimatedLines()

                    Box(
                        contentAlignment = Alignment.TopStart, modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 10.dp, top = 5.dp)
                        ) {
                            currentExercise?.let {
                                it.title?.let { it1 ->
                                    Text(
                                        text = it1,
                                        style = Typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }

                                it.numberOfRepetitions?.let { it1 ->
                                    Text(
                                        text = stringResource(id = R.string.repetitions) + " " + it1.toString(),
                                        style = Typography.labelMedium,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }

                                it.numberOfCircles?.let { it1 ->
                                    Text(
                                        text = stringResource(id = R.string.circles) + " " + it1.toString(),
                                        style = Typography.labelMedium,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }


                            }
                        }
                        if (currentExercise?.exerciseType == ExerciseType.TIME) {

                            Row(
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                            ) {
                                

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier

                                        .height(72.dp)
                                        .width(72.dp)
                                ) {
                                    val durationOfOneCircle =
                                        currentExercise.durationOfOneCircle?.toInt() ?: 0

                                    val progress by animateFloatAsState(
                                        targetValue = if (isOnPause) 1f else 0f,
                                        label = "",
                                        animationSpec = tween(
                                            durationMillis = durationOfOneCircle,
                                        )
                                    )


                                    CircularProgressIndicator(
                                        progress = progress,
                                        color = redColor,
                                        trackColor = MaterialTheme.colorScheme.onPrimary,
                                        strokeWidth = 10.dp,
                                        strokeCap = StrokeCap.Round,
                                        modifier = Modifier
                                            .height(52.dp)
                                            .width(52.dp)

                                    )

                                    Text(
                                        text = "%.0f%%".format(progress * 100),
                                        style = Typography.bodySmall

                                    )
                                }
                            }


                        }


                    }


                }


            }
            Box(
                contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()
            ) {
                val startStopButtonAnimation by animateDpAsState(
                    targetValue = if (isOnPause) 0.dp else 5.dp, label = "", animationSpec = tween(
                        durationMillis = 500
                    )
                )
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(bottom = 25.dp)
                        .clip(
                            RoundedCornerShape(100.dp)
                        )
                        .shadow(2.dp, ambientColor = MaterialTheme.colorScheme.onPrimary)
                        .height(80.dp + startStopButtonAnimation)
                        .width(80.dp + startStopButtonAnimation)

                        .background(MaterialTheme.colorScheme.primary)
                        .clickable(
                            interactionSource = interactionSource, indication = null
                        ) {
                            isOnPause = !isOnPause
                        }) {
                    if (isOnPause) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_play),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.scale(2f)
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_pause),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.scale(2f)
                        )
                    }
                }
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxSize()
        ) {
            exerciseList?.forEach {
//                Spacer(modifier = Modifier.height(10.dp))

                if (it == exerciseList.get(currentExerciseIndex)) {
                    ExerciseCard(exercise = it, true)
                } else {
                    ExerciseCard(exercise = it, isExerciseInProgress = false)
                }


            }
        }
    }
}


@Composable
fun AnimatedLines() {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val firstLineAnimation by infiniteTransition.animateValue(
        initialValue = 0.dp,
        targetValue = 15.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 4000, delayMillis = 700
            ), RepeatMode.Reverse
        ),
        label = ""
    )

    val secondLineAnimation by infiniteTransition.animateValue(
        initialValue = 0.dp,
        targetValue = 15.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 4000, delayMillis = 500
            ), RepeatMode.Reverse
        ),
        label = ""
    )

    val thirdLineAnimation by infiniteTransition.animateValue(
        initialValue = 0.dp,
        targetValue = 15.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 4000, delayMillis = 300
            ), RepeatMode.Reverse
        ),
        label = ""
    )

    Box(
        modifier = Modifier
            .padding(top = 25.dp)
            .clip(
                MaterialTheme.shapes.medium.copy(
                    topStart = CornerSize(4.dp),
                    bottomStart = CornerSize(4.dp),
                    topEnd = CornerSize(0.dp),
                    bottomEnd = CornerSize(0.dp)
                )
            )
            .height(8.dp)
            .width(170.dp + firstLineAnimation)
            .background(MaterialTheme.colorScheme.primary)

    ) {}
    Box(
        modifier = Modifier
            .padding(top = 45.dp)
            .clip(
                MaterialTheme.shapes.medium.copy(
                    topStart = CornerSize(4.dp),
                    bottomStart = CornerSize(4.dp),
                    topEnd = CornerSize(0.dp),
                    bottomEnd = CornerSize(0.dp)
                )
            )
            .height(8.dp)
            .width(120.dp + secondLineAnimation)
            .background(MaterialTheme.colorScheme.primary)

    ) {}
    Box(
        modifier = Modifier
            .padding(top = 65.dp)
            .clip(
                MaterialTheme.shapes.medium.copy(
                    topStart = CornerSize(4.dp),
                    bottomStart = CornerSize(4.dp),
                    topEnd = CornerSize(0.dp),
                    bottomEnd = CornerSize(0.dp)
                )
            )
            .height(8.dp)
            .width(60.dp + thirdLineAnimation)
            .background(MaterialTheme.colorScheme.primary)

    ) {}
}