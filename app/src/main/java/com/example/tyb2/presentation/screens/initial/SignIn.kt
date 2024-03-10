package com.example.tyb2.presentation.screens.initial

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tyb2.R
import com.example.tyb2.presentation.components.Bubbles
import com.example.tyb2.presentation.components.animations.AnimatedFieldBrush
import com.example.tyb2.presentation.components.animations.animatedBorder
import com.example.tyb2.presentation.components.curves.Curve4
import com.example.tyb2.presentation.ui.theme.blueColor
import com.example.tyb2.presentation.ui.theme.greenColor
import com.example.tyb2.presentation.ui.theme.orangeColor
import com.example.tyb2.presentation.ui.theme.purpleColor
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.presentation.ui.theme.robotoFamily
import com.example.tyb2.presentation.ui.theme.yellowColor
import com.example.tyb2.util.Screen


// Вход
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignInScreen(
    navController: NavHostController,
    signInViewModel: SignInViewModel = hiltViewModel()
) {
    // TODO error color(if authorization failed)
    var passwordVisible by remember { mutableStateOf(false) }
    var userEmail by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Curve4(
                color = purpleColor,
                scaleFactor = 3f,
                x = 150.dp,
                y = -20.dp,
                weight = 16f
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Spacer(modifier = Modifier.size(256.dp))
                OutlinedTextField(
                    value = userEmail,
                    onValueChange = { userEmail = it },
                    textStyle = MaterialTheme.typography.bodyMedium,
                    placeholder = {
                        Text(
                            text = "Email",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary.copy(0.5f)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                        focusedTextColor = MaterialTheme.colorScheme.primary,
                        unfocusedTextColor = MaterialTheme.colorScheme.primary,
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.background,
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(320.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                OutlinedTextField(
                    value = userPassword,
                    onValueChange = { userPassword = it },
                    textStyle = MaterialTheme.typography.bodyMedium,
                    placeholder = {
                        Text(
                            text = "Password",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary.copy(0.5f)
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisible = !passwordVisible
                        }) {
                            Icon(
                                painter = painterResource(
                                    id = if (passwordVisible) R.drawable.icon_show
                                    else R.drawable.icon_hide
                                ),
                                contentDescription = "Invisible password",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                        focusedTextColor = MaterialTheme.colorScheme.primary,
                        unfocusedTextColor = MaterialTheme.colorScheme.primary,
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.background,
                    ),
                    modifier = Modifier
                        .width(320.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                OutlinedButton(
                    onClick = {
                        // TODO Log In logic
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(256.dp)
                        .height(52.dp)
                        .animatedBorder(
                            brushColors = listOf(redColor, purpleColor),

                            )
                ) {
                    Text(
                        text = "Log in",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.width(256.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "No account yet?",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    TextButton(onClick = {
                        navController.navigate(Screen.SIGN_UP)
                    }) {
                        Text(
                            text = "Register",
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = TextStyle(
                                brush = AnimatedFieldBrush()
                            ),
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            lineHeight = 16.sp,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(modifier = Modifier.offset(340.dp, 2.dp)) {
                    Bubbles(color = greenColor, size = 108.dp)
                }
                Box(modifier = Modifier.offset(288.dp, 78.dp)) {
                    Bubbles(color = redColor, size = 148.dp)
                }
                Box(modifier = Modifier.offset(-30.dp, 2.dp)) {
                    Bubbles(color = orangeColor, size = 72.dp)
                }
                Box(modifier = Modifier.offset(-58.dp, 48.dp)) {
                    Bubbles(color = purpleColor, size = 172.dp)
                }
                Box(modifier = Modifier.offset(92.dp, 90.dp)) {
                    Bubbles(color = blueColor, size = 172.dp)
                }
                Box(modifier = Modifier.offset(220.dp, 90.dp)) {
                    Bubbles(color = yellowColor, size = 128.dp)
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun PreviewLogIn() {
//    TYB2Theme {
//        SignInScreen()
//    }
//}