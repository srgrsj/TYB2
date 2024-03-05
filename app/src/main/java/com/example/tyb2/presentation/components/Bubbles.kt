package com.example.tyb2.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Bubbles(
    color: Color,
    size: Dp = 168.dp
) {
    Box(
        modifier = Modifier
            .size(size),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .background(color.copy(alpha = 0.4f), RoundedCornerShape(100))
        )
        Box(
            modifier = Modifier
                .size((size - (size / 8)))
                .background(color.copy(alpha = 0.6f), RoundedCornerShape(100))
        )
        Box(
            modifier = Modifier
                .size(size - ((size / 8) * 2))
                .background(color.copy(alpha = 0.8f), RoundedCornerShape(100))
        )
        Box(
            modifier = Modifier
                .size(size - ((size / 8) * 3))
                .background(color, RoundedCornerShape(100))
        )
    }
}