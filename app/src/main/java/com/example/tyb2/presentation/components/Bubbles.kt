package com.example.tyb2.presentation.components

import androidx.compose.animation.core.EaseInOutBack
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
            .size(size*1.1f),
        contentAlignment = Alignment.Center
    ) {
        val infiniteTransition = rememberInfiniteTransition()
        val scale by infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue = 1.1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 4000,
                    delayMillis = 500,
                    easing = EaseInOutBack
                ),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        )
        Box(
            modifier = Modifier
                .size(size * scale)
                .background(color.copy(alpha = 0.4f), RoundedCornerShape(100))
        )
        Box(
            modifier = Modifier
                .size((size - (size / 8))* scale)
                .background(color.copy(alpha = 0.6f), RoundedCornerShape(100))
        )
        Box(
            modifier = Modifier
                .size((size - ((size / 8) * 2))* scale)
                .background(color.copy(alpha = 0.8f), RoundedCornerShape(100))
        )
        Box(
            modifier = Modifier
                .size((size - ((size / 8) * 3))* scale)
                .background(color, RoundedCornerShape(100))
        )
    }
}