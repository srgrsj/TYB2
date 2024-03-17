package com.example.tyb2.presentation.screens.generators.defaultGenerator.alertDialogs

import android.content.res.Resources
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.glance.text.Text
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tyb2.R
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.presentation.screens.generators.defaultGenerator.DefaultGeneratorViewModel
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.presentation.ui.theme.background

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Preview
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
        modifier = Modifier
            .height(525.dp),
        onDismissRequest = {
            viewModel.hideAddExerciseAlertDialog()
        },
        content = {

        }
    )
}

