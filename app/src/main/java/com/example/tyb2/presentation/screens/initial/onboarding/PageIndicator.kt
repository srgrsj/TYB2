package com.example.tyb2.presentation.screens.initial.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.tyb2.presentation.ui.theme.blueColor

@Composable
fun PageIndicator(
    pageSize: Int = 3,
    selectedPage: Int
) {
//    val width by animateDpAsState(
//        if selectedPage
//    )
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageSize) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .height(16.dp)
                    .width(
                        if (it == selectedPage) 56.dp else 16.dp)
                    .clip(RoundedCornerShape(100))
                    .background(
                        if (it == selectedPage)
                            (blueColor) else
                            (blueColor.copy(0.3f))
                    )
            ) {

            }
        }
    }
}