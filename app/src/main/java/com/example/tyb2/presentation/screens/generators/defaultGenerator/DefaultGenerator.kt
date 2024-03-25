package com.example.tyb2.presentation.screens.generators.defaultGenerator

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tyb2.R
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.model.WorkoutSource
import com.example.tyb2.presentation.components.ExercisePreview
import com.example.tyb2.presentation.screens.generators.defaultGenerator.alertDialogs.AddExerciseAlertDialog
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.presentation.ui.theme.robotoFamily
import com.example.tyb2.util.Muscle
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultGenerator(
    navController: NavController,
    viewModel: DefaultGeneratorViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.padding(bottom = 52.dp),
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 52.dp),
                containerColor = MaterialTheme.colorScheme.onPrimary,
                onClick = {
                    viewModel.showAddExerciseAlertDialog()
                },
                elevation = FloatingActionButtonDefaults.elevation(),
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) {
        val exerciseList by viewModel.exerciseList.collectAsState()
        val muscleList = mutableListOf<Muscle>()

        exerciseList.forEach {
            it.muscleList?.forEach() {
                muscleList.add(it)
            }
        }

        var searchBarValue by remember {
            mutableStateOf("")
        }
        var workoutTitle by remember {
            mutableStateOf("")
        }


        val showAddExerciseDialogState: Boolean by viewModel.showAddExerciseDialog.collectAsState()
        if (showAddExerciseDialogState) {
            AddExerciseAlertDialog(viewModel)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .height(50.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    SearchBar(
                        colors = SearchBarDefaults.colors(MaterialTheme.colorScheme.onPrimary),
                        shape = RoundedCornerShape(10.dp),
                        query = searchBarValue,
                        onQueryChange = { searchBarValue = it },
                        onSearch = {},
                        active = false,
                        placeholder = {
                            Text(
                                text = "Поиск по упражнениям",
                                style = Typography.labelMedium.copy(fontSize = 14.sp),
                                color = MaterialTheme.colorScheme.primary
                            )
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_search),
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        },
                        onActiveChange = {},
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(50.dp)

                    ) {}
                }

                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(start = 20.dp, top = 5.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_left_arrow),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .scale(1.78f)
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                }
            }



            Column {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 20.dp, start = 15.dp)
//                ) {
//                    Text(
//                        text = "Title",
//                        color = MaterialTheme.colorScheme.onPrimary,
//                        style = Typography.headlineMedium
//                    )
//                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                ) {
//                var isTitleTextFieldReadOnly by remember {
//                    mutableStateOf(true)
//                }
                    OutlinedTextField(
                        value = workoutTitle,
                        label = {
                            Text(
                                text = "Название",
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        },
                        onValueChange = { workoutTitle = it },
//                    readOnly = isTitleTextFieldReadOnly,
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_edit),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary,
//                            modifier = Modifier
//                                .clickable {
//                                    isTitleTextFieldReadOnly = false
//                                }
                            )
                        },
                        textStyle = TextStyle(
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            letterSpacing = 0.5.sp
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f),
                            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                            unfocusedContainerColor = MaterialTheme.colorScheme.onBackground,
                            focusedContainerColor = MaterialTheme.colorScheme.onBackground,
                            cursorColor = MaterialTheme.colorScheme.onPrimary,
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
//                            .border(
//                                3.dp,
//                                MaterialTheme.colorScheme.onPrimary,
//                                RoundedCornerShape(10.dp)
//                            )
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                Text(
                    text = "Упражнения",
                    style = Typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .padding(start = 15.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 20.dp, bottom = 52.dp)
                        .verticalScroll(ScrollState(0), true)
                ) {
                    exerciseList.forEach {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            val delete = SwipeAction(
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Delete,
                                        contentDescription = null
                                    )
                                },
                                background = redColor,
                                isUndo = true,
                                onSwipe = {
                                    viewModel.removeExerciseFromExerciseList(it)
                                },
                            )

                            SwipeableActionsBox(
                                endActions = listOf(delete)
                            ) {
                                ExercisePreview(exercise = it)

                            }

                        }

                        Spacer(modifier = Modifier.height(15.dp))

                    }
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .height(52.dp)
                        .background(MaterialTheme.colorScheme.onBackground)
                        .border(
                            3.dp,
                            MaterialTheme.colorScheme.onPrimary,
                            RoundedCornerShape(10.dp)
                        )
                        .clickable {
                            viewModel.saveWorkoutToRealtimeDatabase(Workout(
                                title = workoutTitle,
                                muscles = muscleList,
                                workoutGenerationType = WorkoutSource.USER,
                                exerciseList = exerciseList
                            ))
                        }

                ) {
                    Text(
                        text = "Сохранить",
                        style = Typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.icon_complete),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }

            }
        }
    }
}

