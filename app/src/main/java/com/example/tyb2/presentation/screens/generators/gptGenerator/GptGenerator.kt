package com.example.tyb2.presentation.screens.generators.gptGenerator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tyb2.R
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.util.Screen

@Composable
fun GptGeneratorScreen(
    navController: NavController,
    viewModel: GPTGeneratorScreenViewModel = hiltViewModel()
) {
    var muscleTextFieldValue by remember { mutableStateOf("") }
    var durationTextFieldValue by remember { mutableStateOf("") }
    var optionsTextFieldValue by remember { mutableStateOf("") }
    var isProcessing by remember { mutableStateOf(false) }
    val context = LocalContext.current

    val isWorkoutGenerate by viewModel.isWorkoutGenerate.collectAsState()
    val generatedWorkout = viewModel.generatedWorkout.value

    LaunchedEffect(key1 = isWorkoutGenerate) {
        if (generatedWorkout != null) {
            viewModel.setCurrentWorkout(generatedWorkout)
        }
        navController.navigate(Screen.WORKOUT_PREVIEW)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.8f),
                value = muscleTextFieldValue,
                onValueChange = {
                    muscleTextFieldValue = it
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.muscle_groups),
                        style = Typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    focusedLabelColor = MaterialTheme.colorScheme.background,
                    focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                    cursorColor = MaterialTheme.colorScheme.onPrimary
                )
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.8f),
                value = durationTextFieldValue,
                onValueChange = {
                    durationTextFieldValue = it
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.desired_duration),
                        style = Typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    focusedLabelColor = MaterialTheme.colorScheme.background,
                    focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                    cursorColor = MaterialTheme.colorScheme.onPrimary
                )
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.8f),
                value = optionsTextFieldValue,
                onValueChange = {
                    optionsTextFieldValue = it
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.additional_requirements),
                        style = Typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    focusedLabelColor = MaterialTheme.colorScheme.background,
                    focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                    cursorColor = MaterialTheme.colorScheme.onPrimary
                )
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        viewModel.generateGptQuery(
                            context = context,
                            muscleGroups = muscleTextFieldValue,
                            desiredDurationOfTraining = durationTextFieldValue,
                            additionalWorkoutRequirements = optionsTextFieldValue
                        )
                        viewModel.getGPTResponse()
                        isProcessing = true
                    }
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .height(50.dp)
                    .fillMaxWidth(0.8f)

            ) {
                Text(
                    text = stringResource(id = R.string.generate_workout),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            if (isProcessing) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                }
                CircularProgressIndicator()
            }
        }
    }
}
