package com.example.tyb2.presentation.screens.main.store

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.tyb2.presentation.ui.theme.blueColor
import com.example.tyb2.presentation.ui.theme.greenColor
import com.example.tyb2.presentation.ui.theme.orangeColor
import com.example.tyb2.presentation.ui.theme.purpleColor
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.presentation.ui.theme.yellowColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(
    device = "spec:width=1440px,height=3120px,dpi=560",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.NONE
)
@Composable
fun PreviewScreen() {
//    StoreScreen()
    MusclesBoxSlim(
        musclesGroup = MusclesGroup.THORACIC
    )
}

@Composable
fun StoreScreen(
//    viewModel: ProfileViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            GridPad()
            Column(
                modifier = Modifier
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TestCardLargeSize()
                TestCardSlimSize()
                TestCardMidSize()
            }
        }
    }
}

@Composable
fun GridPad() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
//        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = 4.dp,
            vertical = 12.dp),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(6) { index ->
            when {
                (index % 6 == 0) or (index % 6 == 4) -> {
                    //? Средняя карточка
                    TestCardMidSize()
                }
                (index % 6 == 1) or (index % 6 == 2) -> {
                    //? Большая карточка
                    TestCardLargeSize()
                }
                (index % 6 == 5) or (index % 6 == 3) -> {
                    //? Маленькая карточка
                    TestCardSlimSize()
                }
            }
        }
    }
}

@Composable
fun TestCardSlimSize(
) {
    Card(
        modifier = Modifier
            .height(82.dp)
            .width(192.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Blue
        ),
        shape = RoundedCornerShape(10)
    ) {}
}

@Composable
fun TestCardMidSize(
) {
    Card(
        modifier = Modifier
            .height(172.dp)
            .width(192.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Red
        ),
        shape = RoundedCornerShape(10)
    ) {}
}

@Composable
fun TestCardLargeSize() {
    Card(
        modifier = Modifier
            .height(264.dp)
            .width(192.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Green
        ),
        shape = RoundedCornerShape(10)
    ) {}
}

@Composable
fun MusclesBoxSlim(
    musclesGroup: MusclesGroup
) {
    val (backgroundColor, image) = checkMuscleGroup(musclesGroup)
//!    var image: Int = R.drawable.pectoral_muscles92x88
    Card(
        modifier = Modifier
            .height(92.dp)
            .width(82.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomStart
        ) {
            Card(
                modifier = Modifier
                    .height(88.dp)
                    .width(78.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.White)
            ) {}
            Card(
                modifier = Modifier
                    .height(84.dp)
                    .width(74.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.White)
            ) {}
            Card(
                modifier = Modifier
                    .height(80.dp)
                    .width(70.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.White)
            ) {}
            Box(
                modifier = Modifier
                    .offset(-16.dp, 0.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(image),
                    contentDescription = "Muscles",
                    alignment = Alignment.BottomCenter,
                    modifier = Modifier
                )
            }
        }
    }
}

fun checkMuscleGroup(musclesGroup: MusclesGroup): MusclesType {
    var backgroundColor: Color = Color.Black
    var image: Int = 12

        when(musclesGroup) {
            MusclesGroup.THORACIC -> {
                backgroundColor = redColor
//                image =
            }

            MusclesGroup.BACK_WIDE -> {
                backgroundColor = blueColor
            }

            MusclesGroup.BACK_TRAPEZOID -> {
                backgroundColor = blueColor
            }

            MusclesGroup.ARM_BICEPS -> {
                backgroundColor = orangeColor
            }

            MusclesGroup.ARM_FOREARM -> {
                backgroundColor = orangeColor
            }

            MusclesGroup.ARM_TRICEPS -> {
                backgroundColor = orangeColor
            }

            MusclesGroup.BRACHIAL_BACK -> {
                backgroundColor = yellowColor
            }

            MusclesGroup.BRACHIAL_FRONT -> {
                backgroundColor = yellowColor
            }

            MusclesGroup.CORE_LATERAL_ABDOMINAL -> {
                backgroundColor = purpleColor
            }

            MusclesGroup.CORE_LUMBAR -> {
                backgroundColor = purpleColor
            }

            MusclesGroup.CORE_STRAIGHT -> {
                backgroundColor = purpleColor
            }

            MusclesGroup.LEG_CALF -> {
                backgroundColor = greenColor
            }

            MusclesGroup.LEG_QUADRICEPS -> {
                backgroundColor = greenColor
            }

            MusclesGroup.LEG_THIGHS -> {
                backgroundColor = greenColor
            }
        }
    return MusclesType(backgroundColor, image)
}

data class MusclesType(val color: Color, val image: Int)

enum class MusclesGroup{
    THORACIC,
    BACK_TRAPEZOID, BACK_WIDE,
    ARM_BICEPS, ARM_TRICEPS, ARM_FOREARM,
    CORE_STRAIGHT, CORE_LATERAL_ABDOMINAL, CORE_LUMBAR,
    BRACHIAL_BACK, BRACHIAL_FRONT,
    LEG_QUADRICEPS, LEG_CALF, LEG_THIGHS
}