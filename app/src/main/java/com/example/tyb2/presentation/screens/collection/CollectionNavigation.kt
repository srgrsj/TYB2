package com.example.tyb2.presentation.screens.collection

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.tyb2.presentation.components.Screen

fun NavGraphBuilder.collection(navController: NavHostController) {
    composable(Screen.Collection.route) {
        Collection(navController)
    }
}