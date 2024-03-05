package com.example.tyb2.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tyb2.R
import com.example.tyb2.presentation.components.Screen
import com.example.tyb2.presentation.screens.activity.ActivityScreen
import com.example.tyb2.presentation.screens.main.MainScreen
import com.example.tyb2.presentation.screens.profile.ProfileScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        composable(Screen.Main.route) {
            MainScreen(navController)
        }
        composable(Screen.Activity.route) {
            ProfileScreen(navController)
        }
        composable(Screen.Profile.route) {
            ActivityScreen(navController)
        }
    }
}
