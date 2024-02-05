package com.example.tyb2.presentation.screens.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.tyb2.presentation.components.Screen

fun NavGraphBuilder.profile(navController: NavHostController) {
    composable(Screen.Profile.route) {
        Profile(navController)
    }
}