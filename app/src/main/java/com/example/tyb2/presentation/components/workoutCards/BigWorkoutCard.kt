package com.example.tyb2.presentation.components.workoutCards

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.tyb2.R
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.exersice.model.ExerciseType
import com.example.tyb2.domain.workout.model.Workout
import com.example.tyb2.domain.workout.model.WorkoutSource
import com.example.tyb2.presentation.screens.main.store.StoreViewModel
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.util.Muscle
import com.example.tyb2.util.MuscleGroup
import com.example.tyb2.util.MuscleStuff
import com.example.tyb2.util.limitToMaxLength
import java.util.Random


@Composable
fun BigWorkoutCard(
    viewModel: StoreViewModel,
    workout: Workout
) {
    var favState by remember {
        mutableStateOf(workout.isInFav)
    }
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(240.dp)
            .border(2.dp, MuscleStuff.defineColor( MuscleStuff.defineGroup(workout.muscles?.first() ?: Muscle.BREAST)), RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.28f)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.6f)
                ) {
                    Text(
                        text = workout.title?.limitToMaxLength(8) ?: "",
                        style = Typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )

                    IconButton(onClick = {
                        viewModel.changeWorkoutFavState(workout)
                        favState = favState?.not()
                        Log.i("big Fav state", favState.toString())
                    }) {
                        Icon(
                            painter = painterResource(
                                id = if (favState == false) R.drawable.icon_save_outlined else R.drawable.icon_save_field
                            ),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .scale(1.2f)
                                .padding(end = 5.dp)
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .height(16.dp)
                            .width(16.dp)
                            .clip(CircleShape)
                            .background(MuscleStuff.defineColor( MuscleStuff.defineGroup(workout.muscles?.first() ?: Muscle.BREAST)))
                    ) {}

                    Text(
                        text = MuscleStuff.defineTitle(MuscleStuff.defineGroup(workout.muscles?.first() ?: Muscle.BREAST)),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = Typography.bodyLarge,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                }
            }

            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MuscleStuff.defineColor( MuscleStuff.defineGroup(workout.muscles?.first() ?: Muscle.BREAST)))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(0.8f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.onPrimary)
                ) {
                    Box(
                        contentAlignment = Alignment.TopEnd,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .clip(CircleShape)
                                .height(5.dp)
                                .width(120.dp)
                                .background(MaterialTheme.colorScheme.primary)
                        ) {}

                        Box(
                            modifier = Modifier
                                .padding(top = 22.dp)
                                .clip(CircleShape)
                                .height(5.dp)
                                .width(100.dp)
                                .background(MaterialTheme.colorScheme.primary)
                        ) {}

                        Box(
                            modifier = Modifier
                                .padding(top = 34.dp)
                                .clip(CircleShape)
                                .height(5.dp)
                                .width(70.dp)
                                .background(MaterialTheme.colorScheme.primary)
                        ) {}
                    }

                    Box(
                        contentAlignment = Alignment.BottomCenter,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(id = MuscleStuff.definePicture(workout.muscles?.first() ?: Muscle.BREAST)),
                            contentDescription = null,
                            modifier = Modifier
                                .scale(2.5f)
                                .padding(bottom = 20.dp)
                        )
                    }

                }

                Box(
                    modifier = Modifier
                        .padding(end = 2.dp)
                        .border(
                            2.dp,
                            MaterialTheme.colorScheme.onPrimary,
                            RoundedCornerShape(10.dp)
                        )
                        .fillMaxSize(0.87f)
                ) {}

                Box(
                    modifier = Modifier
                        .padding(end = 2.dp)
                        .border(
                            2.dp,
                            MaterialTheme.colorScheme.onPrimary,
                            RoundedCornerShape(10.dp)
                        )
                        .fillMaxSize(0.95f)
                ) {}
            }
        }
    }
}