package com.example.tyb2.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tyb2.util.Muscle
import com.example.tyb2.util.MuscleStuff

@Composable
fun MuscleBox(muscle: Muscle) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    val border by animateDpAsState(
        targetValue = if (isSelected) 5.dp else 0.dp,
        label = "",
        animationSpec = tween(
            durationMillis = 500
        )

    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.onPrimary)
            .size(150.dp)
            .border(
                border,
                MuscleStuff.defineColor(MuscleStuff.defineGroup(muscle)),
                RoundedCornerShape(10.dp)
            )
            .clickable {
                isSelected = !isSelected

            }
    ) {
        Image(
            painter = painterResource(id = MuscleStuff.definePicture(muscle)),
            contentDescription = null,
            modifier = Modifier.scale(2.5f)
        )
    }
}
