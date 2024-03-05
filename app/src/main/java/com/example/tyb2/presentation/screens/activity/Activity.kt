package com.example.tyb2.presentation.screens.activity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tyb2.presentation.components.BottomNavigationBar
import com.example.tyb2.presentation.screens.profile.ProfileViewModel

@Composable
fun ActivityScreen(
    navController: NavHostController,
    viewModel: ActivityViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 46.dp)
    ) {
        Text("Activity")
    }
}