package com.example.tyb2.presentation.components.curves

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Curve1(
    color: Color,
    scaleFactor: Float,
    x : Dp,
    y : Dp,
    angle: Float = 0f,
    weight: Float
) {
    Canvas(
        modifier = Modifier
            .offset(x, y)
            .size(111.dp * scaleFactor, 129.dp * scaleFactor)
            .rotate(angle)
    ) {
        val path = Path().apply {
            moveTo(37.7092f * scaleFactor, 2.34452f * scaleFactor)
            cubicTo(
                28.9087f * scaleFactor, 6.55356f * scaleFactor,
                15.1381f * scaleFactor, 21.2332f * scaleFactor,
                10.0076f * scaleFactor, 28.1811f * scaleFactor
            )
            cubicTo(
                5.55292f * scaleFactor, 34.2138f * scaleFactor,
                0.179117f * scaleFactor, 44.0574f * scaleFactor,
                2.37595f * scaleFactor, 49.6468f * scaleFactor
            )
            cubicTo(
                5.6866f * scaleFactor, 58.0701f * scaleFactor,
                12.0205f * scaleFactor, 62.1748f * scaleFactor,
                22.3458f * scaleFactor, 66.1557f * scaleFactor
            )
            cubicTo(
                31.8637f * scaleFactor, 69.8254f * scaleFactor,
                47.4505f * scaleFactor, 73.7871f * scaleFactor,
                53.178f * scaleFactor, 80.5057f * scaleFactor
            )
            cubicTo(
                59.9732f * scaleFactor, 88.4769f * scaleFactor,
                62.745f * scaleFactor, 97.305f * scaleFactor,
                64.7791f * scaleFactor, 107.251f * scaleFactor
            )
            cubicTo(
                66.4023f * scaleFactor, 115.187f * scaleFactor,
                67.9459f * scaleFactor, 125.334f * scaleFactor,
                79.1806f * scaleFactor, 126.915f * scaleFactor
            )
            cubicTo(
                88.2816f * scaleFactor, 128.196f * scaleFactor,
                99.6268f * scaleFactor, 125.21f * scaleFactor,
                109.055f * scaleFactor, 121.505f * scaleFactor
            )
        }
        drawPath(
            path = path,
            color = color,
            style = Stroke(width = weight)
        )
    }
}