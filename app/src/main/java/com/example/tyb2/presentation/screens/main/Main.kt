package com.example.tyb2.presentation.screens.main

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tyb2.R
import com.example.tyb2.util.Screen
import com.example.tyb2.presentation.components.workoutCards.TestShedevroCard
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.presentation.ui.theme.blueColor
import com.example.tyb2.presentation.ui.theme.greenColor
import com.example.tyb2.presentation.ui.theme.orangeColor
import com.example.tyb2.presentation.ui.theme.purpleColor
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.presentation.ui.theme.yellowColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val interactionSource = remember { MutableInteractionSource() }

    var searchBarValue by remember {
        mutableStateOf("")
    }

    val littleTransparent by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.6f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 4000,
                delayMillis = 500
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .padding(
                    top = 15.dp
                )
        ) {
            Box(
                contentAlignment = Alignment.Center,
            )
            {
                Circles()
                Box(
                    contentAlignment = Alignment.Center,
                ) {
                    Box(
                        modifier = Modifier
                            .padding(
                                top = 100.dp
                            )
                            .clip(RoundedCornerShape(300.dp))
                            .height(220.dp)
                            .width(220.dp)
                            .alpha(0.4f)
                            .background(MaterialTheme.colorScheme.onPrimary)
                            .clickable { }


                    ) {}

                    Box(
                        modifier = Modifier
                            .padding(
                                top = 100.dp
                            )
                            .clip(RoundedCornerShape(300.dp))
                            .height(200.dp)
                            .width(200.dp)
                            .alpha(0.6f)
                            .background(MaterialTheme.colorScheme.onPrimary)
                            .clickable { }


                    ) {}

                    Box(
                        modifier = Modifier
                            .padding(
                                top = 100.dp
                            )
                            .clip(RoundedCornerShape(300.dp))
                            .height(180.dp)
                            .width(180.dp)
                            .alpha(0.8f)
                            .background(MaterialTheme.colorScheme.onPrimary)
                            .clickable { }


                    ) {}

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(
                                top = 100.dp
                            )
                            .clip(RoundedCornerShape(300.dp))
                            .height(160.dp)
                            .width(160.dp)
                            .background(MaterialTheme.colorScheme.onPrimary)
                            .alpha(littleTransparent)
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ) {
//                                navController.navigate()
                            }

                    ) {
                        Text(
                            text = "Flow",
                            style = Typography.displayLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                }


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SearchBar(
                    colors = SearchBarDefaults.colors(MaterialTheme.colorScheme.onPrimary),
                    shape = RoundedCornerShape(10.dp),
                    query = searchBarValue,
                    onQueryChange = { searchBarValue = it },
                    onSearch = {},
                    active = false,
                    placeholder = {
                        Text(
                            text = "Search",
                            style = Typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    onActiveChange = {},
                    modifier = Modifier
                        .fillMaxWidth(0.95f)

                ) {}
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, top = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.workouts),
                style = Typography.displayLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.STORE)
                    }
            )

            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(top = 10.dp)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            TestShedevroCard()
            Spacer(modifier = Modifier.width(10.dp))
            TestShedevroCard()
            Spacer(modifier = Modifier.width(10.dp))
            TestShedevroCard()
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, top = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Yoga",
                style = Typography.displayLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(top = 10.dp)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            TestShedevroCard()
            Spacer(modifier = Modifier.width(10.dp))
            TestShedevroCard()
            Spacer(modifier = Modifier.width(10.dp))
            TestShedevroCard()
        }

    }

}

@Composable
fun Circles() {

    val infiniteTransition = rememberInfiniteTransition(label = "")

    val left by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 30f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 4000,
                delayMillis = 500
            ),
            repeatMode = RepeatMode.Reverse

        ),
        label = ""
    )

    val top by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 30f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 4000,
                delayMillis = 500
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    val plusRadius by infiniteTransition.animateValue(
        initialValue = 0.dp,
        targetValue = 7.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 4000,
                delayMillis = 500
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        translate(left = -750 - left, top = -250f - top) {
            drawCircle(redColor, radius = 90.dp.toPx() + plusRadius.toPx(), alpha = 0.4f)
            drawCircle(redColor, radius = 80.dp.toPx() + plusRadius.toPx(), alpha = 0.6f)
            drawCircle(redColor, radius = 70.dp.toPx() + plusRadius.toPx(), alpha = 0.8f)
            drawCircle(redColor, radius = 60.dp.toPx() + plusRadius.toPx())
        }
    }

    Canvas(modifier = Modifier.fillMaxWidth()) {
        translate(left = -650f - left, top = -70f - top) {
            drawCircle(orangeColor, radius = 50.dp.toPx() + plusRadius.toPx(), alpha = 0.4f)
            drawCircle(orangeColor, radius = 40.dp.toPx() + plusRadius.toPx(), alpha = 0.6f)
            drawCircle(orangeColor, radius = 30.dp.toPx() + plusRadius.toPx(), alpha = 0.8f)
            drawCircle(orangeColor, radius = 20.dp.toPx() + plusRadius.toPx())
        }
    }

    Canvas(modifier = Modifier.fillMaxWidth()) {
        translate(left = 700f + left, top = -250f - top) {
            drawCircle(blueColor, radius = 90.dp.toPx() + plusRadius.toPx(), alpha = 0.4f)
            drawCircle(blueColor, radius = 80.dp.toPx() + plusRadius.toPx(), alpha = 0.6f)
            drawCircle(blueColor, radius = 70.dp.toPx() + plusRadius.toPx(), alpha = 0.8f)
            drawCircle(blueColor, radius = 60.dp.toPx() + plusRadius.toPx())
        }
    }

    Canvas(modifier = Modifier.fillMaxWidth()) {
        translate(left = -650f - left, top = 700f + top) {
            drawCircle(purpleColor, radius = 90.dp.toPx() + plusRadius.toPx(), alpha = 0.4f)
            drawCircle(purpleColor, radius = 80.dp.toPx() + plusRadius.toPx(), alpha = 0.6f)
            drawCircle(purpleColor, radius = 70.dp.toPx() + plusRadius.toPx(), alpha = 0.8f)
            drawCircle(purpleColor, radius = 60.dp.toPx() + plusRadius.toPx())
        }
    }

    Canvas(modifier = Modifier.fillMaxWidth()) {
        translate(left = 700f + left, top = 800f + top) {
            drawCircle(yellowColor, radius = 85.dp.toPx() + plusRadius.toPx(), alpha = 0.4f)
            drawCircle(yellowColor, radius = 75.dp.toPx() + plusRadius.toPx(), alpha = 0.6f)
            drawCircle(yellowColor, radius = 65.dp.toPx() + plusRadius.toPx(), alpha = 0.8f)
            drawCircle(yellowColor, radius = 55.dp.toPx() + plusRadius.toPx())
        }
    }

    Canvas(modifier = Modifier.fillMaxWidth()) {
        translate(left = 650f + left, top = 600f + top) {
            drawCircle(greenColor, radius = 70.dp.toPx() + plusRadius.toPx(), alpha = 0.4f)
            drawCircle(greenColor, radius = 60.dp.toPx() + plusRadius.toPx(), alpha = 0.6f)
            drawCircle(greenColor, radius = 50.dp.toPx() + plusRadius.toPx(), alpha = 0.8f)
            drawCircle(greenColor, radius = 40.dp.toPx() + plusRadius.toPx())
        }
    }
}