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
fun Curve3(
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
            moveTo(256.409f * scaleFactor, 3.87197f * scaleFactor)
            cubicTo(
                253.726f * scaleFactor, -1.46075f * scaleFactor,
                227.904f * scaleFactor, 5.06948f * scaleFactor,
                223.916f * scaleFactor, 5.58945f * scaleFactor
            )
            cubicTo(
                213.113f * scaleFactor, 6.99765f * scaleFactor,
                199.765f * scaleFactor, 6.92131f * scaleFactor,
                190.439f * scaleFactor, 13.6318f * scaleFactor
            )
            cubicTo(
                176.526f * scaleFactor, 23.6438f * scaleFactor,
                169.253f * scaleFactor, 40.128f * scaleFactor,
                157.246f * scaleFactor, 51.7196f * scaleFactor
            )
            cubicTo(
                143.966f * scaleFactor, 64.5409f * scaleFactor,
                123.534f * scaleFactor, 69.4597f * scaleFactor,
                106.455f * scaleFactor, 75.2162f * scaleFactor
            )
            cubicTo(
                83.1653f * scaleFactor, 83.0661f * scaleFactor,
                58.0615f * scaleFactor, 85.7476f * scaleFactor,
                38.4937f * scaleFactor, 102.281f * scaleFactor
            )
            cubicTo(
                28.0218f * scaleFactor, 111.128f * scaleFactor,
                13.8157f * scaleFactor, 131.386f * scaleFactor,
                12.8986f * scaleFactor, 145.962f * scaleFactor
            )
            cubicTo(
                12.5372f * scaleFactor, 151.706f * scaleFactor,
                7.8243f * scaleFactor, 157.729f * scaleFactor,
                6.35799f * scaleFactor, 163.29f * scaleFactor
            )
            cubicTo(
                4.91665f * scaleFactor, 168.756f * scaleFactor,
                4.21641f * scaleFactor, 174.341f * scaleFactor,
                3.37845f * scaleFactor, 179.822f * scaleFactor
            )
            cubicTo(
                2.98553f * scaleFactor, 182.392f * scaleFactor,
                3.28141f * scaleFactor, 188.427f * scaleFactor,
                1.9983f * scaleFactor, 189.8f * scaleFactor
            )
        }
        drawPath(
            path = path,
            color = color,
            style = Stroke(width = weight)
        )
    }
}