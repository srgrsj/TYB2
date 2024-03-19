package com.example.tyb2.presentation.screens.generators.defaultGenerator.alertDialogs

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tyb2.R
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.presentation.components.MuscleBox
import com.example.tyb2.presentation.components.TimePicker
import com.example.tyb2.presentation.screens.generators.defaultGenerator.DefaultGeneratorViewModel
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.util.MuscleStuff

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
//@Preview
@Composable
fun AddExerciseAlertDialog(
    viewModel: DefaultGeneratorViewModel = hiltViewModel()
) {
    var title: String by remember { mutableStateOf("") }
    var numberOfRepetitions: Int by remember { mutableStateOf(0) }
    val numberOfRepetitionsIsError by remember { mutableStateOf(false) }
    var numberOfCircles: Int by remember { mutableStateOf(0) }
    var numberOfCirclesIsError by remember { mutableStateOf(false) }
    val durationOfOneCircle = remember { mutableStateOf(0L) }
    val muscleList by viewModel.muscleList.collectAsState()
    var durationOfOneCircleIsError by remember { mutableStateOf(false) }
    val durationOfRest = remember { mutableStateOf(0L) }
    var durationOfRestIsError by remember { mutableStateOf(false) }
    var exerciseType: ExerciseType by remember { mutableStateOf(ExerciseType.REPETITION) }
    val context = LocalContext.current
    val pagerState = rememberPagerState(
        pageCount = {
            2
        }
    )


    AlertDialog(
        properties = DialogProperties(usePlatformDefaultWidth = false),
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        onDismissRequest = {
            viewModel.hideAddExerciseAlertDialog()
        },
        content = {
            Scaffold(
                floatingActionButtonPosition = FabPosition.End,
                floatingActionButton = {
                    FloatingActionButton(
                        modifier = Modifier
                            .padding(bottom = 52.dp),
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                        onClick = {
                            if (numberOfCircles == 0) {
                                numberOfCirclesIsError = true
                            }

                            if (pagerState.currentPage == 0) {
                                viewModel.saveExerciseToExerciseList(
                                    Exercise(
                                        title = title,
                                        numberOfCircles = numberOfCircles,
                                        numberOfRepetitions = numberOfRepetitions,
                                        exerciseType = ExerciseType.REPETITION,
                                        muscleList = muscleList
                                    )
                                )

                            } else if (pagerState.currentPage == 1) {
                                viewModel.saveExerciseToExerciseList(
                                    Exercise(
                                        title = title,
                                        numberOfCircles = numberOfCircles,
                                        durationOfOneCircle = durationOfOneCircle.value,
                                        durationOfRest = durationOfRest.value,
                                        exerciseType = ExerciseType.TIME,
                                        muscleList = muscleList
                                    )
                                )
                            }

                            viewModel.hideAddExerciseAlertDialog()
                            viewModel.cleanMuscleList()

                        },
                        elevation = FloatingActionButtonDefaults.elevation(),
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_complete),
                            contentDescription = null
                        )
                    }
                }
            ) {
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
//                                text = pagerState.currentPage.toString(),
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
                                        MuscleBox(muscle = it, viewModel = viewModel)
                                    }
                                }
                            }
                        })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        HorizontalPager(state = pagerState) { page ->
                            when (page) {
                                0 -> {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.spacedBy(30.dp),
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(MaterialTheme.colorScheme.onBackground)
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .padding(bottom = 10.dp, top = 20.dp)
                                        ) {
                                            Text(
                                                text = "Repetitions",
                                                style = Typography.headlineMedium,
                                                color = MaterialTheme.colorScheme.onPrimary
                                            )
                                        }

                                        OutlinedTextField(
                                            modifier = Modifier,
                                            value = title,
                                            onValueChange = { title = it },
                                            label = {
                                                Text(
                                                    text = "Title",
                                                    style = Typography.bodyLarge,
                                                    color = MaterialTheme.colorScheme.onPrimary
                                                )
                                            },
                                            colors = OutlinedTextFieldDefaults.colors(
                                                focusedContainerColor = MaterialTheme.colorScheme.background,
                                                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                                                focusedLabelColor = MaterialTheme.colorScheme.background,
                                                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                                                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary
                                            )
                                        )

                                        OutlinedTextField(
                                            modifier = Modifier,
                                            value = numberOfRepetitions.toString(),
                                            isError = numberOfRepetitionsIsError,
                                            onValueChange = {
                                                numberOfRepetitions = it.toInt()
                                            },
                                            label = {
                                                Text(
                                                    text = "Repetitions",
                                                    style = Typography.bodyLarge,
                                                    color = MaterialTheme.colorScheme.onPrimary
                                                )
                                            },
                                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                            colors = OutlinedTextFieldDefaults.colors(
                                                focusedContainerColor = MaterialTheme.colorScheme.background,
                                                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                                                focusedLabelColor = MaterialTheme.colorScheme.background,
                                                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                                                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary
                                            )
                                        )


                                        OutlinedTextField(
                                            modifier = Modifier,
                                            value = numberOfCircles.toString(),
                                            isError = numberOfCirclesIsError,
                                            onValueChange = {
                                                numberOfCircles = it.toInt()
                                            },
                                            label = {
                                                Text(
                                                    text = "Circles",
                                                    style = Typography.bodyLarge,
                                                    color = MaterialTheme.colorScheme.onPrimary
                                                )
                                            },
                                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                            colors = OutlinedTextFieldDefaults.colors(
                                                focusedContainerColor = MaterialTheme.colorScheme.background,
                                                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                                                focusedLabelColor = MaterialTheme.colorScheme.background,
                                                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                                                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary
                                            )
                                        )

                                    }
                                }

                                1 -> {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.spacedBy(30.dp),
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(MaterialTheme.colorScheme.onBackground)
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .padding(bottom = 10.dp, top = 20.dp)
                                        ) {
                                            Text(
                                                text = "Time",
                                                style = Typography.headlineMedium,
                                                color = MaterialTheme.colorScheme.onPrimary
                                            )
                                        }

                                        OutlinedTextField(
                                            modifier = Modifier,
                                            value = title,
                                            onValueChange = { title = it },
                                            label = {
                                                Text(
                                                    text = "Title",
                                                    style = Typography.bodyLarge,
                                                    color = MaterialTheme.colorScheme.onPrimary
                                                )
                                            },
                                            colors = OutlinedTextFieldDefaults.colors(
                                                focusedContainerColor = MaterialTheme.colorScheme.background,
                                                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                                                focusedLabelColor = MaterialTheme.colorScheme.background,
                                                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                                                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary
                                            )
                                        )

                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Column(
                                                horizontalAlignment = Alignment.Start
                                            ) {
                                                Text(
                                                    text = "Work:",
                                                    style = Typography.bodyLarge,
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    modifier = Modifier.padding(bottom = 5.dp)
                                                )
                                                TimePicker(value = durationOfOneCircle)
                                            }
                                        }

                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Column(
                                                horizontalAlignment = Alignment.Start
                                            ) {
                                                Text(
                                                    text = "Rest:",
                                                    style = Typography.bodyLarge,
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    modifier = Modifier.padding(bottom = 5.dp)
                                                )
                                                TimePicker(value = durationOfOneCircle)
                                            }
                                        }

                                        OutlinedTextField(
                                            modifier = Modifier,
                                            value = numberOfCircles.toString(),
                                            isError = numberOfCirclesIsError,
                                            onValueChange = { numberOfCircles = it.toInt() },
                                            label = {
                                                Text(
                                                    text = "Circles",
                                                    style = Typography.bodyLarge,
                                                    color = MaterialTheme.colorScheme.onPrimary
                                                )
                                            },
                                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                            colors = OutlinedTextFieldDefaults.colors(
                                                focusedContainerColor = MaterialTheme.colorScheme.background,
                                                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                                                focusedLabelColor = MaterialTheme.colorScheme.background,
                                                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                                                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary
                                            )
                                        )

                                    }
                                }
                            }
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(20.dp),
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth()
                        ) {
//                        Row(
//                            modifier = Modifier
//                                .height(80.dp)
//
//                        ) {
//                            Text(
//                                text = "Save",
//                                style = Typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
//                                color = MaterialTheme.colorScheme.onPrimary
//                            )
//
//                            Icon(
//                                painter = painterResource(id = R.drawable.icon_complete),
//                                contentDescription = null,
//                                tint = MaterialTheme.colorScheme.onPrimary
//                            )
//
//                        }

                            Row(
                                Modifier
                                    .wrapContentHeight()
                                    .padding(bottom = 8.dp),
                            ) {
                                repeat(pagerState.pageCount) { iteration ->
                                    val color =
                                        if (pagerState.currentPage == iteration) Color.LightGray else Color.Gray
                                    Box(
                                        modifier = Modifier
                                            .padding(2.dp)
                                            .clip(CircleShape)
                                            .background(color)
                                            .size(8.dp)
                                    )
                                }
                            }

                        }
                    }
                }
            }
        }
    )
}
