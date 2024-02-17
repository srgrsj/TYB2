package com.example.tyb2.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tyb2.presentation.screens.profile.ProfileScreen
import com.example.tyb2.presentation.screens.workouts.main.MainScreen
import com.example.tyb2.presentation.screens.workouts.store.StoreScreen

@OptIn(ExperimentalAnimationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = NavConstants.MAIN,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        composable(NavConstants.MAIN) {
            MainScreen()
        }
        composable(NavConstants.PROFILE) {
            ProfileScreen()
        }
        composable(NavConstants.STORE) {
            StoreScreen()
        }

    }

//    AnimatedNavHost(
//        navController = navHostController,
//        startDestination = NavConstants.MAIN,
//    ) {
//        composable(NavConstants.MAIN) {
//            MainScreen()
//        }
//        composable(NavConstants.PROFILE) {
//            ProfileScreen()
//        }
//        composable(NavConstants.STORE) {
//            StoreScreen()
//        }
//    }
}