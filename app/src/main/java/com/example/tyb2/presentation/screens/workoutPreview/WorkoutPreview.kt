package com.example.tyb2.presentation.screens.workoutPreview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.glance.text.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.tyb2.presentation.components.ExerciseCard

@Composable
fun WorkoutPreview(
    viewModel: WorkoutPreviewViewModel = hiltViewModel()
) {
    val workout by viewModel.currentWorkout.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
        ) {
            workout?.exerciseList?.forEach {
                Spacer(modifier = Modifier.height(10.dp))
                ExerciseCard(exercise = it)
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .width(100.dp)
            ) {
                Text(text = "Cancel")
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .width(100.dp)
            ) {
                Text(text = "Save")
            }

        }
    }
}