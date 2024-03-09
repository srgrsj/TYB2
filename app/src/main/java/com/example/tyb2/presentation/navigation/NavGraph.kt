package com.example.tyb2.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tyb2.util.Screen
import com.example.tyb2.presentation.screens.activity.ActivityScreen
import com.example.tyb2.presentation.screens.main.MainScreen
import com.example.tyb2.presentation.screens.main.store.StoreScreen
import com.example.tyb2.presentation.screens.profile.ProfileScreen
import com.example.tyb2.presentation.screens.profile.achievements.AchievementsScreen
import com.example.tyb2.presentation.screens.profile.body_features.BodyFeaturesScreen
import com.example.tyb2.presentation.screens.profile.calendar.CalendarScreen
import com.example.tyb2.presentation.screens.profile.profile_settings.ProfileSettingsScreen
import com.example.tyb2.presentation.screens.profile.settings.SettingsScreen

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
//            ProfileScreen(navController)
        }
        composable(Screen.Activity.route) {
            ActivityScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(Screen.ACHIEVEMENT_ROUTE) {
            AchievementsScreen(navController)
        }
        composable(Screen.BODY_FEATURES_ROUTE) {
            BodyFeaturesScreen(navController)
        }
        composable(Screen.CALENDAR_ROUTE) {
            CalendarScreen(navController)
        }
        composable(Screen.PROFILE_SETTINGS) {
            ProfileSettingsScreen(navController)
        }
        composable(Screen.SETTINGS) {
            SettingsScreen(navController)
        }
        composable(Screen.STORE){
            StoreScreen()
        }
    }
}