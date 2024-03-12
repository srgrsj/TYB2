package com.example.tyb2.presentation.screens.activity

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tyb2.R
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.presentation.components.workoutCards.WorkoutCard
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.util.Screen

@Composable
fun ActivityScreen(
    navController: NavHostController,
    viewModel: ActivityViewModel = hiltViewModel()
) {
    val createdWorkoutsLis by viewModel.createdWorkoutList.collectAsState()
    val savedWorkoutList: List<Workout>

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 52.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, bottom = 10.dp)
                .clickable {
                    navController.navigate(Screen.DEFAULT_GENERATOR)
                }
        ) {
            Text(
                text = "Cоздать тренировку",
                color = MaterialTheme.colorScheme.onPrimary,
                style = Typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )

            Icon(
                painter = painterResource(id = R.drawable.icon_right_arrow),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(top = 6.dp)
            )
        }

        LazyRow(content = {
            createdWorkoutsLis.forEach() {
                item {
                    WorkoutCard(workout = it)
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        })

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, top = 30.dp, bottom = 10.dp)
        ) {
            Text(
                text = "Сохраненные тренировки",
                color = MaterialTheme.colorScheme.onPrimary,
                style = Typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )

            Icon(
                painter = painterResource(id = R.drawable.icon_right_arrow),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(top = 6.dp)
            )
        }

        LazyRow(
            content = {
                createdWorkoutsLis.forEach() {
                    item {
                        WorkoutCard(workout = it)
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            },
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
}