package com.example.tyb2.presentation.screens.profile.body_features

import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tyb2.R
import com.example.tyb2.domain.user.model.User
import com.example.tyb2.presentation.components.ProfileNavRow
import com.example.tyb2.presentation.ui.theme.blueColor
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.util.getUserAvatar

@Composable
fun BodyFeaturesScreen(
    navController: NavHostController,
    viewModel: BodyFeaturesViewModel = hiltViewModel()
) {
    // TODO список должен быть в firebase
    var bodyFeaturesList by remember { mutableStateOf(mutableListOf("Item 1", "Item 2")) }

//    val userAvatarData = viewModel.userAvatar.collectAsState()
//    val userAvatar = getUserAvatar(userAvatarData.value)
////    val userData by viewModel.userData.collectAsState()
//    var manCheck by remember {
//        mutableStateOf(userAvatarData.value == "m")
//    }
//    var womanCheck by remember {
//        mutableStateOf(false)
//    }
//    LaunchedEffect(key1 = viewModel.userAvatar) {
//        viewModel.userAvatar.collect { avatarData ->
//            Log.i("vm change", "$avatarData")
//        }
//    }
//    val borderWidthMan by animateDpAsState(
//        targetValue = if (manCheck) 32.dp else 6.dp,
//        label = "",
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioNoBouncy,
//            stiffness = Spring.StiffnessMedium
//        )
//    )
//    val borderWidthWoman by animateDpAsState(
//        targetValue = if (womanCheck) 32.dp else 6.dp,
//        label = "",
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioNoBouncy,
//            stiffness = Spring.StiffnessMedium
//        )
//    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ProfileNavRow(
                navController = navController,
                icon = R.drawable.icon_body_features,
                title = "Особенности тела",
                img = R.drawable.profile_avatar_default
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
//                Box(
//                    modifier = Modifier.background(MaterialTheme.colorScheme.onBackground),
//                    contentAlignment = Alignment.Center,
//                ) {
//
//                }
//                Text(
//                    text = "Пол",
//                    style = MaterialTheme.typography.titleLarge,
//                    color = MaterialTheme.colorScheme.onPrimary
//                )
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth(0.5f)
//                            .fillMaxHeight()
//                            .padding(horizontal = 6.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.Start
//                    ) {
//                        Button(
//                            onClick = {
//                                womanCheck = true
//                                manCheck = false
//                                viewModel.setUserAvatarData("w")
//                            },
//                            shape = CircleShape,
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = Color.Transparent,
//                                contentColor = Color.Transparent
//                            ),
//                            border = BorderStroke(
//                                borderWidthWoman,
//                                redColor
//                            ),
//                            modifier = Modifier.size(32.dp)
//                        ) {
//
//                        }
//                        Spacer(modifier = Modifier.width(4.dp))
//                        Text(
//                            text = "Женский",
//                            style = MaterialTheme.typography.bodyMedium,
//                            color = MaterialTheme.colorScheme.onPrimary
//                        )
//                    }
//                    Spacer(modifier = Modifier.weight(1f))
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .fillMaxHeight()
//                            .padding(horizontal = 6.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.Start
//                    ) {
//                        Button(
//                            onClick = {
//                                womanCheck = false
//                                manCheck = true
//                                viewModel.setUserAvatarData("m")
//                            },
//                            shape = CircleShape,
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = Color.Transparent,
//                                contentColor = Color.Transparent
//                            ),
//                            border = BorderStroke(
//                                borderWidthMan,
//                                blueColor
//                            ),
//                            modifier = Modifier.size(32.dp)
//                        ) {
//
//                        }
//                        Spacer(modifier = Modifier.width(4.dp))
//                        Text(
//                            text = "Мужской",
//                            style = MaterialTheme.typography.bodyMedium,
//                            color = MaterialTheme.colorScheme.onPrimary
//                        )
//                    }
//                }
            }
        }
    }
}