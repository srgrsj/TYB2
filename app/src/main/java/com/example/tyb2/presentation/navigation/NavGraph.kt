package com.example.tyb2.presentation.navigation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tyb2.data.user.AccountData
import com.example.tyb2.presentation.screens.activity.ActivityScreen
import com.example.tyb2.presentation.screens.generators.defaultGenerator.DefaultGenerator
import com.example.tyb2.presentation.screens.generators.gptGenerator.GptGeneratorScreen
import com.example.tyb2.presentation.screens.initial.auth.signIn.SignInScreen
import com.example.tyb2.presentation.screens.initial.auth.signUp.SignUpScreen
import com.example.tyb2.presentation.screens.main.MainScreen
import com.example.tyb2.presentation.screens.main.store.StoreScreen
import com.example.tyb2.presentation.screens.main.workoutpPlayback.WorkoutPlayback
import com.example.tyb2.presentation.screens.profile.ProfileScreen
import com.example.tyb2.presentation.screens.profile.achievements.AchievementsScreen
import com.example.tyb2.presentation.screens.profile.body_features.BodyFeaturesScreen
import com.example.tyb2.presentation.screens.profile.calendar.CalendarScreen
import com.example.tyb2.presentation.screens.profile.profile_settings.ProfileSettingsScreen
import com.example.tyb2.presentation.screens.profile.settings.SettingsScreen
import com.example.tyb2.util.Screen

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SuspiciousIndentation")
@Composable
fun NavGraph(
    navController: NavHostController
) {
    //TODO start destination
    val startDestination =
        if (AccountData.EMAIL.isNullOrEmpty()) Screen.SIGN_IN else Screen.Main.route
//    val startDestination = Screen.GPT_GENERATOR
//    val startDestination = Screen.Main.route
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        composable(Screen.Main.route) {
            MainScreen(navController)
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
        composable(Screen.STORE) {
            StoreScreen(navController)
        }
        composable(Screen.SIGN_IN) {
            SignInScreen(navController)
        }
        composable(Screen.SIGN_UP) {
            SignUpScreen(navController)
        }
        composable(Screen.DEFAULT_GENERATOR) {
            DefaultGenerator(navController)
        }
        composable(Screen.GPT_GENERATOR) {
            GptGeneratorScreen(navController)
        }
        composable(Screen.WORKOUT_PLAYBACK) {
            WorkoutPlayback(navController)
        }
    }
}