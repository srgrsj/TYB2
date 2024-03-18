package com.example.tyb2.presentation.screens.profile.achievements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tyb2.R
import com.example.tyb2.domain.user.model.Achievement
import com.example.tyb2.domain.user.model.userAchievementsList
import com.example.tyb2.presentation.components.ProfileNavRow
import com.example.tyb2.presentation.components.animations.animatedBorder
import com.example.tyb2.presentation.ui.theme.purpleColor
import com.example.tyb2.presentation.ui.theme.redColor

@Composable
fun AchievementsScreen(
    navController: NavHostController,
    viewModel: AchievementsViewModel = hiltViewModel()
) {
    val achievementsList = userAchievementsList
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
                icon = R.drawable.icon_achievements,
                title = "Достижения"
            )
        }
    }
}

@Composable
fun AchievementElement(
    achievement: Achievement
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
            .animatedBorder(
                brushColors = listOf(redColor, purpleColor),
                backgroundColor = MaterialTheme.colorScheme.onBackground,
                borderWidth = 4.dp,
                shape = RoundedCornerShape(10.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        ),
    ) {

    }
}

@Preview
@Composable
private fun CardPrev() {
    AchievementElement(achievement = userAchievementsList.get(2))
}