package com.example.tyb2.presentation.screens.profile.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tyb2.R
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.presentation.components.ProfileNavRow
import com.example.tyb2.presentation.components.workoutCards.BigWorkoutCard
import com.example.tyb2.presentation.components.workoutCards.MidWorkoutCard
import com.example.tyb2.presentation.components.workoutCards.SlimWorkoutCard
import com.example.tyb2.presentation.screens.main.store.StoreViewModel
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.util.getUserAvatar

/** Вместо календаря тренировок здесь храняться сохраненные пользователем тренировки **/
@Composable
fun CalendarScreen(
    navController: NavHostController,
    viewModel: CalendarViewModel = hiltViewModel()
) {
    val userAvatarData = viewModel.userAvatar.collectAsState()
    val userAvatar = getUserAvatar(userAvatarData.value)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ProfileNavRow(
                img = R.drawable.profile_avatar_default,
                navController = navController,
                icon = R.drawable.icon_calendar,
                title = "Сохраненные тренировки",
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                val favList = mutableListOf<Workout>()
                val workouts by viewModel.workoutList.collectAsState()

                workouts.forEach {
                    if (it.isInFav == true) {
                        favList.add(it)
                    }
                }

                if (favList.isNotEmpty()) {
                    GridPad(viewModel = viewModel, workoutsList = favList)
                } else {
                    Box (
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Вы еще не добавили ни одной тренировки",
                            style = Typography.headlineLarge,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                }
            }
        }


    }
}

@Composable
fun GridPad(
    viewModel: StoreViewModel,
    workoutsList: List<Workout>
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
//        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = 4.dp,
            vertical = 12.dp
        ),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(workoutsList.size) { index ->
            when {
                (index % 6 == 0) or (index % 6 == 4) -> {
                    MidWorkoutCard(
                        viewModel = viewModel,
                        workout = workoutsList[index]
                    )
                }

                (index % 6 == 1) or (index % 6 == 2) -> {
                    BigWorkoutCard(
                        viewModel = viewModel,
                        workout = workoutsList[index]
                    )
                }

                (index % 6 == 5) or (index % 6 == 3) -> {
                    SlimWorkoutCard(
                        viewModel = viewModel,
                        workout = workoutsList[index]
                    )
                }
            }
        }
    }
}