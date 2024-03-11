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
fun Curve4(
    color: Color,
    scaleFactor: Float,
    x: Dp,
    y: Dp,
    angle: Float = 0f,
    weight: Float
) {
    Canvas(
        modifier = Modifier
            .offset(x, y)
            .size(266.dp * scaleFactor, 193.dp * scaleFactor)
            .rotate(angle)
    ) {
        val path = Path().apply {
            moveTo(145.624f * scaleFactor, 335.649f * scaleFactor)
            cubicTo(
                138.91f * scaleFactor, 334.306f * scaleFactor,
                131.537f * scaleFactor, 326.263f * scaleFactor,
                126.228f * scaleFactor, 322.392f * scaleFactor
            )
            cubicTo(
                106.256f * scaleFactor, 307.829f * scaleFactor,
                84.1401f * scaleFactor, 296.209f * scaleFactor,
                64.8508f * scaleFactor, 280.777f * scaleFactor
            )
            cubicTo(
                48.6707f * scaleFactor, 267.833f * scaleFactor,
                31.7654f * scaleFactor, 253.622f * scaleFactor,
                18.4492f * scaleFactor, 237.69f * scaleFactor
            )
            cubicTo(
                7.16398f * scaleFactor, 224.188f * scaleFactor,
                22.296f * scaleFactor, 208.568f * scaleFactor,
                30.8475f * scaleFactor, 197.549f * scaleFactor
            )
            cubicTo(
                54.5037f * scaleFactor, 167.069f * scaleFactor,
                91.2194f * scaleFactor, 121.689f * scaleFactor,
                88.1743f * scaleFactor, 80.0724f * scaleFactor
            )
            cubicTo(
                85.8452f * scaleFactor, 48.2422f * scaleFactor,
                48.9417f * scaleFactor, 30.4618f * scaleFactor,
                24.2187f * scaleFactor, 17.9582f * scaleFactor
            )
            cubicTo(
                16.8707f * scaleFactor, 14.242f * scaleFactor,
                5.88179f * scaleFactor, 9.76357f * scaleFactor,
                2f * scaleFactor, 2f * scaleFactor
            )
        }
        drawPath(
            path = path,
            color = color,
            style = Stroke(width = weight)
        )
    }
}