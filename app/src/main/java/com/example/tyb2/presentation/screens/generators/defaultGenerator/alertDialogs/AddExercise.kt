package com.example.tyb2.presentation.screens.generators.defaultGenerator.alertDialogs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.presentation.components.MuscleBox
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.util.MuscleStuff

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun AddExerciseAlertDialog(
//    viewModel: DefaultGeneratorViewModel = hiltViewModel()
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
        modifier = Modifier
            .height(525.dp)
        ,
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
                .height(40.dp)
                .width(80.dp)
                .background(MaterialTheme.colorScheme.onSecondary)
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
                .height(40.dp)
                .width(80.dp)
                .background(MaterialTheme.colorScheme.onSecondary)
        ) {
            Text(
                text = "Time"
            )
        }
    }
}
