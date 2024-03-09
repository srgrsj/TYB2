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
            moveTo(145.624f, 335.649f)
            cubicTo(
                138.91f, 334.306f,
                131.537f, 326.263f,
                126.228f, 322.392f
            )
            cubicTo(
                106.256f, 307.829f,
                84.1401f, 296.209f,
                64.8508f, 280.777f
            )
            cubicTo(
                48.6707f, 267.833f,
                31.7654f, 253.622f,
                18.4492f, 237.69f
            )
            cubicTo(
                7.16398f, 224.188f,
                22.296f, 208.568f,
                30.8475f, 197.549f
            )
            cubicTo(
                54.5037f, 167.069f,
                91.2194f, 121.689f,
                88.1743f, 80.0724f
            )
            cubicTo(
                85.8452f, 48.2422f,
                48.9417f, 30.4618f,
                24.2187f, 17.9582f
            )
            cubicTo(
                16.8707f, 14.242f,
                5.88179f, 9.76357f,
                2f, 2f
            )
        }
        drawPath(
            path = path,
            color = color,
            style = Stroke(width = weight)
        )
    }
}