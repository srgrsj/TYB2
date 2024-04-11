package com.example.tyb2.presentation.screens.main.store

import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tyb2.R
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.presentation.components.workoutCards.BigWorkoutCard
import com.example.tyb2.presentation.components.workoutCards.MidWorkoutCard
import com.example.tyb2.presentation.components.workoutCards.SlimWorkoutCard
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.presentation.ui.theme.blueColor
import com.example.tyb2.presentation.ui.theme.greenColor
import com.example.tyb2.presentation.ui.theme.orangeColor
import com.example.tyb2.presentation.ui.theme.purpleColor
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.presentation.ui.theme.robotoFamily
import com.example.tyb2.presentation.ui.theme.yellowColor
import com.example.tyb2.util.Muscle
import com.example.tyb2.util.MuscleGroup
import com.example.tyb2.util.MuscleStuff

@Preview
@Composable
fun StorePreview() {
//    StoreScreen()
}

@Composable
fun StoreScreen(
    navController: NavController,
    viewModel: StoreViewModel = hiltViewModel(),
) {
    var isRedSelected by remember { mutableStateOf(false) }
    var isOrangeSelected by remember { mutableStateOf(false) }
    var isYellowSelected by remember { mutableStateOf(false) }
    var isGreenSelected by remember { mutableStateOf(false) }
    var isBlueSelected by remember { mutableStateOf(false) }
    var isPurpleSelected by remember { mutableStateOf(false) }

    val allCategories by remember {
        mutableStateOf(
            isRedSelected || isOrangeSelected || isYellowSelected
                    || isGreenSelected || isBlueSelected || isPurpleSelected
        )
    }

    val sortCategories = mutableListOf<Muscle>()

    if (isGreenSelected) sortCategories.addAll(MuscleStuff.defineMuscle(MuscleGroup.LEG))
    else sortCategories.removeAll(MuscleStuff.defineMuscle(MuscleGroup.LEG))
    if (isBlueSelected) sortCategories.addAll(MuscleStuff.defineMuscle(MuscleGroup.BACK))
    else sortCategories.removeAll(MuscleStuff.defineMuscle(MuscleGroup.BACK))
    if (isPurpleSelected) sortCategories.addAll(MuscleStuff.defineMuscle(MuscleGroup.CORE))
    else sortCategories.removeAll(MuscleStuff.defineMuscle(MuscleGroup.CORE))
    if (isRedSelected)  sortCategories.addAll(MuscleStuff.defineMuscle(MuscleGroup.BREAST))
    else  sortCategories.removeAll(MuscleStuff.defineMuscle(MuscleGroup.BREAST))
    if (isOrangeSelected)  sortCategories.addAll(MuscleStuff.defineMuscle(MuscleGroup.ARM))
    else sortCategories.removeAll(MuscleStuff.defineMuscle(MuscleGroup.ARM))
    if (isYellowSelected)  sortCategories.addAll(MuscleStuff.defineMuscle(MuscleGroup.BRACHIAL))
    else sortCategories.removeAll(MuscleStuff.defineMuscle(MuscleGroup.BRACHIAL))

//    var displayingWO = viewModel.sortWorkoutListByCategory(
//        sortCategories = sortCategories,
//        allCategories = allCategories
//    )

    val readyWorkouts by viewModel.allWorkoutsList.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.getReadyWorkouts(context)
//        viewModel.getReadyYoga(context)
    }
    LaunchedEffect(key1 = sortCategories) {
        Log.i("Categories", sortCategories.toString())
        Log.i("All", allCategories.toString())
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 52.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 40.dp)
                .height(52.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxSize()
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_left_arrow),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .scale(2f)
                            .padding(start = 10.dp)
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Витрина",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 42.sp,
                        letterSpacing = 0.5.sp
                    )
                )
            }
        }

        var isFilterBoxOpen by remember {
            mutableStateOf(true)
        }
        val filterBoxHeight by animateDpAsState(
            targetValue = if (isFilterBoxOpen) 270.dp else 0.dp,
            label = "",
            animationSpec = tween(
                durationMillis = 500
            )

        )
        Box(
            modifier = Modifier
                .height(filterBoxHeight)
                .width(350.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row {
                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp)
                            .clickable {
                                isRedSelected = !isRedSelected
                                //TODO
                                viewModel.sortWorkoutListByCategory(
                                    sortCategories = sortCategories,
                                    allCategories = false
                                )
                            }
                    ) {
                        Box(
                            contentAlignment = Alignment.BottomEnd,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            SelectableCircle(
                                color = redColor,
                                isSelected = isRedSelected
                            )
                        }

                        Box(
                            contentAlignment = Alignment.TopStart,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "Грудь",
                                style = Typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onPrimary,
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(7.dp))

                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp)
                            .clickable {
                                isPurpleSelected = !isPurpleSelected
                                //TODO
                                viewModel.sortWorkoutListByCategory(
                                    sortCategories = sortCategories,
                                    allCategories = false
                                )
                            }
                    ) {
                        Box(
                            contentAlignment = Alignment.BottomStart,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            SelectableCircle(
                                color = purpleColor,
                                isSelected = isPurpleSelected
                            )
                        }

                        Box(
                            contentAlignment = Alignment.TopEnd,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "Кора",
                                style = Typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onPrimary,
                            )
                        }
                    }

                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(120.dp)
                            .clickable {
                                isOrangeSelected = !isOrangeSelected
                                //TODO
                                viewModel.sortWorkoutListByCategory(
                                    sortCategories = sortCategories,
                                    allCategories = false
                                )

                            }
                    ) {
                        Text(
                            text = "Руки",
                            style = Typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .padding(end = 5.dp)
                        )

                        SelectableCircle(
                            color = orangeColor,
                            isSelected = isOrangeSelected
                        )
                    }

                    Spacer(modifier = Modifier.width(90.dp))

                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(120.dp)
                            .clickable {
                                isBlueSelected = !isBlueSelected
                                //TODO
                                viewModel.sortWorkoutListByCategory(
                                    sortCategories = sortCategories,
                                    allCategories = false
                                )
                            }
                    ) {
                        SelectableCircle(
                            color = blueColor,
                            isSelected = isBlueSelected
                        )

                        Text(
                            text = "Спина",
                            style = Typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .padding(start = 5.dp)
                        )
                    }

                }

                Row {
                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp)
                            .clickable {
                                //TODO
                                isYellowSelected = !isYellowSelected
                                viewModel.sortWorkoutListByCategory(
                                    sortCategories = sortCategories,
                                    allCategories = false
                                )
                            }
                    ) {
                        Box(
                            contentAlignment = Alignment.TopEnd,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            SelectableCircle(
                                color = yellowColor,
                                isSelected = isYellowSelected
                            )
                        }

                        Box(
                            contentAlignment = Alignment.BottomStart,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "Плечи",
                                style = Typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onPrimary,
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(7.dp))

                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp)
                            .clickable {
                                isGreenSelected = !isGreenSelected
                                //TODO
                                viewModel.sortWorkoutListByCategory(
                                    sortCategories = sortCategories,
                                    allCategories = false
                                )
                            }
                    ) {
                        Box(
                            contentAlignment = Alignment.TopStart,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            SelectableCircle(
                                color = greenColor,
                                isSelected = isGreenSelected
                            )
                        }

                        Box(
                            contentAlignment = Alignment.BottomEnd,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "Ноги",
                                style = Typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onPrimary,
                            )
                        }
                    }
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp)
                .clickable {
                    isFilterBoxOpen = !isFilterBoxOpen
                }
        ) {

            Text(
                text = "Лучшее",
                color = MaterialTheme.colorScheme.onPrimary,
                style = TextStyle(
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 32.sp,
                    letterSpacing = 0.5.sp
                )
            )

            Icon(
                painter = painterResource(id = R.drawable.icon_sort),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .scale(1.2f)
                    .padding(start = 5.dp)
            )

        }

        GridPad(
            viewModel,
            readyWorkouts
        )
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


@Composable
fun SelectableCircle(
    color: Color,
    isSelected: Boolean
) {
    val borderWidth by animateDpAsState(
        targetValue = if (isSelected) 6.dp else 0.dp,
        label = "",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMedium,

            )
    )
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .height(64.dp)
            .width(64.dp)
            .background(color)
            .border(
                borderWidth,
                MaterialTheme.colorScheme.onPrimary,
                shape = CircleShape
            )
    ) {}
}