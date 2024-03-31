package com.example.tyb2.presentation.screens.profile.body_features

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
    var bodyFeaturesList by remember { mutableStateOf(mutableListOf("Item 1", "Item 2")) }

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

@Composable
fun SelectableCircle(
    color: Color,
    isSelected: Boolean
) {
    // TODO make checkbox for pick gender
    val borderWidth by animateDpAsState(
        targetValue = if (isSelected) 6.dp else 0.dp,
        label = "",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .height(64.dp)
            .width(64.dp)
            .background(color)
            .border(
                borderWidth,
                MaterialTheme.colorScheme.onPrimary,
                shape = CircleShape
            )
    ) {
        TODO()
    }
}