package com.example.tyb2

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tyb2.presentation.components.BottomNavigationBar
import com.example.tyb2.presentation.navigation.NavGraph
import com.example.tyb2.presentation.screens.initial.auth.signIn.SignInScreen
import com.example.tyb2.presentation.ui.theme.TYB2Theme
import com.example.tyb2.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TYB2Theme {
                Application()
//                SignInScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Application() {
    val navController = rememberNavController()
    val screensWithoutNavbar = listOf(Screen.SIGN_IN, Screen.SIGN_UP)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { if (navBackStackEntry?.destination?.route !in screensWithoutNavbar) { BottomNavigationBar(navController = navController)} }
    ) {
        NavGraph(navController)
    }
}