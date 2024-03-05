package com.example.tyb2.presentation.screens.main

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tyb2.presentation.screens.workoutpPlayback.ShedevroWorkout

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    ShedevroWorkout(navController)
}