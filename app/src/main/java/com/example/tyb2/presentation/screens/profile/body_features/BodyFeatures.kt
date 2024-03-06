package com.example.tyb2.presentation.screens.profile.body_features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tyb2.R
import com.example.tyb2.presentation.components.ProfileNavRow

@Composable
fun BodyFeaturesScreen(
    navController: NavHostController,
    viewModel: BodyFeaturesViewModel = hiltViewModel()
) {
    // TODO список должен быть в firebase
    var body_features_list by remember { mutableStateOf(mutableListOf("Item 1", "Item 2")) }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ProfileNavRow(
                navController = navController,
                icon = R.drawable.icon_body_features,
                title = "Особенности тела"
            )
        }
    }
}