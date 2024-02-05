package com.example.tyb2.presentation.screens.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.tyb2.presentation.components.Screen

fun NavGraphBuilder.main(navController: NavHostController) {
    composable(Screen.Main.route) {
        Main(navController)
    }
}