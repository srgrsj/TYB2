package com.example.tyb2.presentation.screens.main.store

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tyb2.R
import com.example.tyb2.presentation.components.workoutCards.TestShedevroCardBig
import com.example.tyb2.presentation.components.workoutCards.TestShedevroCardMid
import com.example.tyb2.presentation.components.workoutCards.TestShedevroCardSlim
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.presentation.ui.theme.blueColor
import com.example.tyb2.presentation.ui.theme.greenColor
import com.example.tyb2.presentation.ui.theme.orangeColor
import com.example.tyb2.presentation.ui.theme.purpleColor
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.presentation.ui.theme.robotoFamily
import com.example.tyb2.presentation.ui.theme.yellowColor

@Preview
@Composable
fun StorePreview() {
    StoreScreen()
}

@Composable
fun StoreScreen(
//    navController: NavController,
//    viewModel: StoreViewModel = hiltViewModel(),
) {
    var isRedSelected by remember { mutableStateOf(false) }
    var isOrangeSelected by remember { mutableStateOf(false) }
    var isYellowSelected by remember { mutableStateOf(false) }
    var isGreenSelected by remember { mutableStateOf(false) }
    var isBlueSelected by remember { mutableStateOf(false) }
    var isPurpleSelected by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 52.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 40.dp)
                .height(52.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_left_arrow),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .scale(2f)
                        .padding(start = 10.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Витрина",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 42.sp,
                        letterSpacing = 0.5.sp
                    )
                )
            }
        }

        Box(
            modifier = Modifier
                .height(240.dp)
                .width(350.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row {
                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp)
                            .clickable { isRedSelected = !isRedSelected }
                    ) {
                        Box(
                            contentAlignment = Alignment.BottomEnd,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            SelectableCircle(
                                color = redColor,
                                isSelected = isRedSelected
                            )
                        }

                        Box(
                            contentAlignment = Alignment.TopStart,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "Грудь",
                                style = Typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onPrimary,
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(7.dp))

                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp)
                            .clickable { isPurpleSelected = !isPurpleSelected }
                    ) {
                        Box(
                            contentAlignment = Alignment.BottomStart,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            SelectableCircle(
                                color = purpleColor,
                                isSelected = isPurpleSelected
                            )
                        }

                        Box(
                            contentAlignment = Alignment.TopEnd,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "Кора",
                                style = Typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onPrimary,
                            )
                        }
                    }

                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(120.dp)
                            .clickable { isOrangeSelected = !isOrangeSelected }
                    ) {
                        Text(
                            text = "Руки",
                            style = Typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .padding(end = 5.dp)
                        )

                        SelectableCircle(
                            color = orangeColor,
                            isSelected = isOrangeSelected
                        )
                    }

                    Spacer(modifier = Modifier.width(90.dp))

                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(120.dp)
                            .clickable { isBlueSelected = !isBlueSelected }
                    ) {
                        SelectableCircle(
                            color = blueColor,
                            isSelected = isBlueSelected
                        )

                        Text(
                            text = "Спина",
                            style = Typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .padding(start = 5.dp)
                        )
                    }

                }

                Row {
                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp)
                            .clickable { isYellowSelected = !isYellowSelected }
                    ) {
                        Box(
                            contentAlignment = Alignment.TopEnd,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            SelectableCircle(
                                color = yellowColor,
                                isSelected = isYellowSelected
                            )
                        }

                        Box(
                            contentAlignment = Alignment.BottomStart,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "Ноги",
                                style = Typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onPrimary,
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(7.dp))

                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp)
                            .clickable { isGreenSelected = !isGreenSelected }
                    ) {
                        Box(
                            contentAlignment = Alignment.TopStart,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            SelectableCircle(
                                color = greenColor,
                                isSelected = isGreenSelected
                            )
                        }

                        Box(
                            contentAlignment = Alignment.BottomEnd,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "Плечи",
                                style = Typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onPrimary,
                            )
                        }
                    }
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            TestShedevroCardBig()
            TestShedevroCardMid()
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            TestShedevroCardBig()
            TestShedevroCardSlim()
        }

    }
}


@Composable
fun SelectableCircle(
    color: Color,
    isSelected: Boolean
) {
    val borderWidth by animateDpAsState(
        targetValue = if (isSelected) 6.dp else 0.dp,
        label = "",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMedium,
            
        )
    )

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .height(64.dp)
            .width(64.dp)
            .background(color)
            .border(
                borderWidth,
                MaterialTheme.colorScheme.onPrimary,
                shape = CircleShape
            )

    ) {}
}