package com.example.tyb2.presentation.screens.generators.defaultGenerator.alertDialogs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.presentation.components.MuscleBox
import com.example.tyb2.presentation.screens.generators.defaultGenerator.DefaultGeneratorViewModel
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.util.MuscleStuff

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
//@Preview
@Composable
fun AddExerciseAlertDialog(
    viewModel: DefaultGeneratorViewModel = hiltViewModel()
) {
    var title: String by remember { mutableStateOf("") }
    var numberOfRepetitions: String by remember { mutableStateOf("") }
    var numberOfRepetitionsIsError by remember { mutableStateOf(false) }
    var numberOfCircles: String by remember { mutableStateOf("") }
    var numberOfCirclesIsError by remember { mutableStateOf(false) }
    val durationOfOneCircle = remember { mutableStateOf(0L) }
    var durationOfOneCircleIsError by remember { mutableStateOf(false) }
    val durationOfRest = remember { mutableStateOf(0L) }
    var durationOfRestIsError by remember { mutableStateOf(false) }
    var exerciseType: ExerciseType by remember { mutableStateOf(ExerciseType.REPETITION) }
    var dropdownOpen: Boolean by remember { mutableStateOf(false) }
    val context = LocalContext.current


    AlertDialog(
        properties = DialogProperties(usePlatformDefaultWidth = false),
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        onDismissRequest = {
            viewModel.hideAddExerciseAlertDialog()
        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Column(
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(bottom = 10.dp, end = 5.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Группы мышц",
                            style = Typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onPrimary
                        )

                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.clickable {
                                viewModel.hideAddExerciseAlertDialog()
                            }
                        )
                    }

                    LazyRow(content = {
                        MuscleStuff.allMuscleList.forEach {
                            item {
                                Box(
                                    modifier = Modifier.padding(end = 10.dp)
                                ) {
                                    MuscleBox(muscle = it)
                                }
                            }
                        }
                    })
                }

                Row(
                    modifier = Modifier
                        .padding(bottom = 10.dp, top = 20.dp)
                ) {
                    Text(
                        text = "Тип упражнения",
                        style = Typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.onBackground)
                ) {
                    var isRepetitionSelected by remember {
                        mutableStateOf(false)
                    }

                    var isTimeSelected by remember {
                        mutableStateOf(false)
                    }

                    val animateRepetitionSize by animateDpAsState(
                        targetValue = if (isRepetitionSelected) 0.dp else 10.dp,
                        label = "",
                        animationSpec = tween(
                            durationMillis = 500
                        )
                    )

                    val animateRepetitionColor by animateFloatAsState(
                        targetValue = if (isRepetitionSelected) 1f else 0.8f,
                        label = "",
                        animationSpec = tween(
                            durationMillis = 500
                        )
                    )



                    val animateTimeSize by animateDpAsState(
                        targetValue = if (isTimeSelected) 0.dp else 10.dp,
                        label = "",
                        animationSpec = tween(
                            durationMillis = 500
                        )
                    )

                    val animateTimeColor by animateFloatAsState(
                        targetValue = if (isTimeSelected) 1f else 0.8f,
                        label = "",
                        animationSpec = tween(
                            durationMillis = 500
                        )
                    )



                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
//                .fillMaxHeight(0.8f)
                                .clip(RoundedCornerShape(5.dp))
                                .height(40.dp - animateRepetitionSize)
                                .width(90.dp - animateRepetitionSize)
                                .background(
                                    MaterialTheme.colorScheme.onSecondary.copy(
                                        alpha = animateRepetitionColor
                                    )
                                )
                                .clickable {
                                    isRepetitionSelected = true
                                    isTimeSelected = false
                                }
                        ) {
                            Text(
                                text = "Repetition"
                            )
                        }

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
//                .fillMaxHeight(0.8f)
                                .clip(RoundedCornerShape(5.dp))
                                .height(40.dp - animateTimeSize)
                                .width(90.dp - animateTimeSize)
                                .background(
                                    MaterialTheme.colorScheme.onSecondary.copy(
                                        alpha = animateTimeColor
                                    )
                                )
                                .clickable {
                                    isTimeSelected = true
                                    isRepetitionSelected = false
                                }
                        ) {
                            Text(
                                text = "Time"
                            )
                        }
                    }


                    AnimatedVisibility(
                        visible = isRepetitionSelected,
                        enter = slideInHorizontally(animationSpec = tween(durationMillis = 200)) { fullWidth ->
                            // Offsets the content by 1/3 of its width to the left, and slide towards right
                            // Overwrites the default animation with tween for this slide animation.
                            -fullWidth / 3
                        } + fadeIn(
                            // Overwrites the default animation with tween
                            animationSpec = tween(durationMillis = 200)
                        ),
                        exit = slideOutHorizontally(animationSpec = spring(stiffness = Spring.StiffnessHigh)) {
                            // Overwrites the ending position of the slide-out to 200 (pixels) to the right
                            200
                        } + fadeOut()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Red)
                        ) {

                        }

                    }

                    AnimatedVisibility(
                        visible = isTimeSelected,
                        enter = slideInHorizontally(animationSpec = tween(durationMillis = 200)) { fullWidth ->
                            // Offsets the content by 1/3 of its width to the left, and slide towards right
                            // Overwrites the default animation with tween for this slide animation.
                            -fullWidth / 3
                        } + fadeIn(
                            // Overwrites the default animation with tween
                            animationSpec = tween(durationMillis = 200)
                        ),
                        exit = slideOutHorizontally(animationSpec = spring(stiffness = Spring.StiffnessHigh)) {
                            // Overwrites the ending position of the slide-out to 200 (pixels) to the right
                            200
                        } + fadeOut()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {

                        }

                    }
                }
            }

        }
    )
}
