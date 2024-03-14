package com.example.tyb2.presentation.screens.initial.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tyb2.presentation.ui.theme.blueColor
import com.example.tyb2.presentation.ui.theme.greenColor
import com.example.tyb2.presentation.ui.theme.purpleColor

@Composable
fun OnBoardingButton(
    currentPage: Int,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    onGetStarted: () -> Unit
) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        if (currentPage != 0) {
            TextButton(onClick = {
                onBackClick()
            }) {
                Text(text = "Back", color = purpleColor)
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            if (currentPage == 2)
                onGetStarted() else onNextClick()
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = blueColor
            )
        ) {
            Text(text = if (currentPage == 2)
                "Get started" else "Next",
                color = greenColor)
        }
    }
}