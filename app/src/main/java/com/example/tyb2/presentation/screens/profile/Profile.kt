package com.example.tyb2.presentation.screens.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.tyb2.R
import com.example.tyb2.presentation.components.BottomNavigationBar
import com.example.tyb2.presentation.components.Bubbles
import com.example.tyb2.presentation.components.curves.Curve1
import com.example.tyb2.presentation.components.curves.Curve2
import com.example.tyb2.presentation.components.curves.Curve3
import com.example.tyb2.presentation.ui.theme.blueColor
import com.example.tyb2.presentation.ui.theme.greenColor
import com.example.tyb2.presentation.ui.theme.orangeColor
import com.example.tyb2.presentation.ui.theme.purpleColor
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.presentation.ui.theme.yellowColor

@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 46.dp)
    ) {
        Curve1(
            color = MaterialTheme.colorScheme.onPrimary,
            scaleFactor = 4f,
            x = 30.dp,
            y = 750.dp,
            angle = 70f,
            weight = 12f
        )
        Curve2(
            color = MaterialTheme.colorScheme.onPrimary,
            scaleFactor = 5f,
            x = 100.dp,
            y = 250.dp,
            angle = -70f,
            weight = 12f
        )
        Curve3(
            color = MaterialTheme.colorScheme.onPrimary,
            scaleFactor = 3f,
            x = -360.dp,
            y = 580.dp,
            angle = 90f,
            weight = 12f
        )
        Curve1(
            color = MaterialTheme.colorScheme.onPrimary,
            scaleFactor = 5f,
            x = -280.dp,
            y = -280.dp,
            angle = 180f,
            weight = 12f
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.35f)
                    .padding(top = 44.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Box(modifier = Modifier.offset(248.dp, -24.dp)) {
                        Bubbles(color = redColor, size = 120.dp)
                    }
                    Box(modifier = Modifier.offset(300.dp, -108.dp)) {
                        Bubbles(color = greenColor, size = 228.dp)
                    }
                    Box(modifier = Modifier.offset(-16.dp, -18.dp)) {
                        Bubbles(color = orangeColor, size = 108.dp)
                    }
                    Box(modifier = Modifier.offset(20.dp, -128.dp)) {
                        Bubbles(color = yellowColor, size = 224.dp)
                    }
                    Box(modifier = Modifier.offset(-58.dp, -100.dp)) {
                        Bubbles(color = purpleColor, size = 120.dp)
                    }
                    Box(modifier = Modifier.offset(156.dp, -160.dp)) {
                        Bubbles(color = blueColor, size = 192.dp)
                    }
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    //            AsyncImage(
                    //                model = ,
                    //                contentDescription = null,
                    //                modifier = Modifier.fillMaxWidth(),
                    //                contentScale = ContentScale.Fit
                    //            )
                    Image(
                        painter = painterResource(id = R.drawable.collection_icon),
                        contentDescription = "Avatar",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(160.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = "Profile name",
// !                      color = MaterialTheme.colorScheme.onPrimary,
                        color = Color.Black,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
            Box(
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .fillMaxWidth()
                    .fillMaxHeight(0.72f)
                    .padding(start = 12.dp, end = 12.dp, top = 12.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ProfileNavigationRow(
                        icon = R.drawable.collection_icon,
                        title = "Достижения"
                    ) {
                        //TODO Навигацияя
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.onPrimary),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            ProfileNavigationRow(
                                icon = R.drawable.collection_icon,
                                title = "Особенности тела"
                            ) {
                                //TODO Навигация
                            }
                            ProfileNavigationRow(
                                icon = R.drawable.collection_icon,
                                title = "Календарь тренировок"
                            ) {
                                //TODO Навигация
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.onPrimary),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            ProfileNavigationRow(
                                icon = R.drawable.collection_icon,
                                title = "Настройки приложения"
                            ) {
                                //TODO Навигация
                            }
                            ProfileNavigationRow(
                                icon = R.drawable.collection_icon,
                                title = "Параметры профиля"
                            ) {
                                //TODO Навигация
                            }
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(modifier = Modifier.offset(340.dp, 32.dp)) {
                    Bubbles(color = greenColor, size = 128.dp)
                }
                Box(modifier = Modifier.offset(288.dp, 108.dp)) {
                    Bubbles(color = redColor, size = 168.dp)
                }
                Box(modifier = Modifier.offset(-30.dp, 32.dp)) {
                    Bubbles(color = orangeColor, size = 92.dp)
                }
                Box(modifier = Modifier.offset(-58.dp, 78.dp)) {
                    Bubbles(color = purpleColor, size = 192.dp)
                }
                Box(modifier = Modifier.offset(92.dp, 120.dp)) {
                    Bubbles(color = blueColor, size = 192.dp)
                }
                Box(modifier = Modifier.offset(220.dp, 120.dp)) {
                    Bubbles(color = yellowColor, size = 148.dp)
                }
            }
        }
    }
}


@Composable
fun ProfileNavigationRow(
    icon: Int,
    title: String,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        modifier = Modifier
            .height(58.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(28.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painterResource(
                    id = R.drawable.collection_icon
                ),
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(28.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun PhotoSelectorButton() {
    var selectedImage by remember {
        mutableStateOf<Uri?>(null)
    }

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImage = uri }
    )


    fun launchPhotoPicker() {
        singlePhotoPickerLauncher.launch(
            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
        )
    }
    Button(onClick = {
        launchPhotoPicker()
    }) {
        Text(
            text = "Select a picture"
        )
    }
    ImageLayoutView(selectedImage = selectedImage)
}

@Composable
fun ImageLayoutView(selectedImage: Uri?) {
    AsyncImage(
        model = selectedImage,
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Fit
    )
}