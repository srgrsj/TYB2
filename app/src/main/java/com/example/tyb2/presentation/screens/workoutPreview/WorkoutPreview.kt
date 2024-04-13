package com.example.tyb2.presentation.screens.workoutPreview

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.tyb2.domain.workout.model.WorkoutSource
import com.example.tyb2.presentation.components.ExercisePreview
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.util.Screen

@Composable
fun WorkoutPreview(
    navController: NavController,
    viewModel: WorkoutPreviewViewModel = hiltViewModel()
) {
    val workout by viewModel.currentWorkout.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            workout?.title?.let {
                Text(
                    text = it,
                    style = Typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                workout?.exerciseList?.forEach {
                    ExercisePreview(exercise = it)
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.onBackground)
                        .fillMaxHeight(0.9f)
                        .width(150.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                ) {
                    Text(
                        text = "Cancel",
                        style = Typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.onBackground)
                        .fillMaxHeight(0.9f)
                        .width(150.dp)
                        .clickable {
                            workout?.let { viewModel.saveWorkout(it.copy(workoutGenerationType = WorkoutSource.GPT)) }
                            navController.navigate(Screen.Main.route)
                        }
                ) {
                    Text(
                        text = "Save",
                        style = Typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }

        }
    }
}