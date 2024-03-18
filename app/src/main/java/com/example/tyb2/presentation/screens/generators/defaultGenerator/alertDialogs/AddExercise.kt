package com.example.tyb2.presentation.screens.generators.defaultGenerator.alertDialogs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
            .background(MaterialTheme.colorScheme.onBackground),
        onDismissRequest = {
//            viewModel.hideAddExerciseAlertDialog()
        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Column(
                    modifier = Modifier.padding(start = 5.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                    ) {
                        Text(
                            text = "Группы мышц",
                            style = Typography.headlineSmall.copy(fontWeight = FontWeight.ExtraBold),
                            color = MaterialTheme.colorScheme.onPrimary
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

                Column {
                    Row(
                        modifier = Modifier
                            .padding(bottom = 10.dp, top = 10.dp)
                    ) {
                        Text(
                            text = "Тип упражнения",
                            style = Typography.headlineSmall.copy(fontWeight = FontWeight.ExtraBold),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth(0.95f)
                            .height(50.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.onBackground)
                    ) {
                        ExerciseTypeButtonSection()
                    }
                }
            }
        }
    )
}


@Composable
fun ExerciseTypeButtonSection(
) {
    var isRepetitionSelected by remember {
        mutableStateOf(true)
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

    var isTimeSelected by remember {
        mutableStateOf(true)
    }

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
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
//                .fillMaxHeight(0.8f)
                .clip(RoundedCornerShape(5.dp))
                .height(40.dp - animateRepetitionSize)
                .width(80.dp - animateRepetitionSize)
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
                .width(80.dp - animateTimeSize)
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
}
