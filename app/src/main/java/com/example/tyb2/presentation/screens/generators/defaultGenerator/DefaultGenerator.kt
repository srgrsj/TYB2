package com.example.tyb2.presentation.screens.generators.defaultGenerator

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tyb2.R
import com.example.tyb2.presentation.components.ExerciseCard
import com.example.tyb2.presentation.components.ExercisePreview
import com.example.tyb2.presentation.screens.generators.defaultGenerator.alertDialogs.AddExerciseAlertDialog
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.presentation.ui.theme.robotoFamily

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
        var searchBarValue by remember {
            mutableStateOf("")
        }
        var workoutTitle by remember {
            mutableStateOf("")
        }

        val exerciseList by viewModel.exerciseList.collectAsState()

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
                                text = "Search by exercises",
                                style = Typography.labelMedium.copy(fontSize = 16.sp),
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
                                text = "Title",
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
                            focusedContainerColor = MaterialTheme.colorScheme.onBackground
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
                    text = "Exercises",
                    style = Typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .padding(start = 15.dp)
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .verticalScroll(ScrollState(0), true)
            ) {
                exerciseList.forEach {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        ExercisePreview(exercise = it)
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                }
            }

        }
    }
}

