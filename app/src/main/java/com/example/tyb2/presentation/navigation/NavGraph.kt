//package com.example.tyb2.presentation.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import com.example.tyb2.presentation.components.Screen
//import com.example.tyb2.presentation.screens.collection.collection
//import com.example.tyb2.presentation.screens.main.main
//import com.example.tyb2.presentation.screens.profile.profile
//
//
//@Composable
//fun NavGraph(
//    navController: NavHostController
//) {
//    NavHost(
//        navController = navController,
//        startDestination = Screen.Main.route
//    ) {
//        main(navController)
//        collection(navController)
//        profile(navController)
//    }
//}