package com.example.tyb2.presentation.screens.initial.auth.signUp

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tyb2.R
import com.example.tyb2.presentation.components.Bubbles
import com.example.tyb2.presentation.components.animations.AnimatedFieldBrush
import com.example.tyb2.presentation.components.curves.Curve1
import com.example.tyb2.presentation.components.curves.Curve3
import com.example.tyb2.presentation.components.curves.Curve4
import com.example.tyb2.presentation.screens.initial.auth.signIn.SignInViewModel
import com.example.tyb2.presentation.ui.theme.TYB2Theme
import com.example.tyb2.presentation.ui.theme.blueColor
import com.example.tyb2.presentation.ui.theme.greenColor
import com.example.tyb2.presentation.ui.theme.orangeColor
import com.example.tyb2.presentation.ui.theme.purpleColor
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.presentation.ui.theme.robotoFamily
import com.example.tyb2.presentation.ui.theme.yellowColor
import com.example.tyb2.util.Screen
import kotlinx.coroutines.launch


// Регестрация
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
    navController: NavHostController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    // TODO error color(if authorization failed)
    var passwordVisible by remember { mutableStateOf(false) }
    var userEmail by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

//    val state = viewModel.signUpState.collectAsState(initial = null)
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current


//    LaunchedEffect(key1 = state.value?.isSuccess) {
//        scope.launch {
//            if (state.value?.isSuccess?.isNotEmpty() == true) {
//                val success = state.value?.isSuccess
//                Toast.makeText(context, "$success", Toast.LENGTH_LONG).show()
//                navController.navigate(Screen.Main.route)
//            }
//        }
//    }
//
//    LaunchedEffect(key1 = state.value?.isError) {
//        scope.launch {
//            if (state.value?.isError?.isNotEmpty() == true) {
//                val error = state.value?.isError
//                Toast.makeText(context, error, Toast.LENGTH_LONG).show()
//            }
//        }
//    }
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(modifier = Modifier.offset(270.dp, 422.dp)) {
                    Bubbles(color = greenColor, size = 108.dp)
                }
                Box(modifier = Modifier.offset(288.dp, 728.dp)) {
                    Bubbles(color = redColor, size = 148.dp)
                }
                Box(modifier = Modifier.offset(230.dp, 442.dp)) {
                    Bubbles(color = orangeColor, size = 72.dp)
                }
                Box(modifier = Modifier.offset(-58.dp, 728.dp)) {
                    Bubbles(color = purpleColor, size = 172.dp)
                }
                Box(modifier = Modifier.offset(-80.dp, 358.dp)) {
                    Bubbles(color = blueColor, size = 172.dp)
                }
                Box(modifier = Modifier.offset(320.dp, 664.dp)) {
                    Bubbles(color = yellowColor, size = 128.dp)
                }
            }
            Curve4(
                color = MaterialTheme.colorScheme.onPrimary,
                scaleFactor = 4f,
                x = 160.dp,
                y = -100.dp,
                weight = 16f,
                angle = -80f
            )
            Curve4(
                color = MaterialTheme.colorScheme.onPrimary,
                scaleFactor = 2f,
                x = -144.dp,
                y = -32.dp,
                weight = 16f,
                angle = 60f
            )
            Curve3(
                color = MaterialTheme.colorScheme.onPrimary,
                scaleFactor = 2f,
                x = 280.dp,
                y = -460.dp,
                angle = -90f,
                weight = 16f
            )
            Curve1(
                color = MaterialTheme.colorScheme.onPrimary,
                scaleFactor = 3f,
                x = 80.dp,
                y = 520.dp,
                angle = 80f,
                weight = 16f
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(x = -64.dp, y = -92.dp)
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .size(256.dp)
                    .background(MaterialTheme.colorScheme.onPrimary))
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(x = 32.dp, y = 360.dp)
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .size(92.dp)
                    .background(MaterialTheme.colorScheme.onPrimary))
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(x = 256.dp, y = 44.dp)
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .size(64.dp)
                    .background(MaterialTheme.colorScheme.onPrimary))
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ) {
                OutlinedTextField(
                    value = userName,
                    onValueChange = { userName = it },
                    textStyle = MaterialTheme.typography.bodyMedium,
                    placeholder = {
                        Text(
                            text = "Username",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary.copy(0.5f)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                        focusedTextColor = MaterialTheme.colorScheme.primary,
                        unfocusedTextColor = MaterialTheme.colorScheme.primary,
                        focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(320.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
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
                        focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
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
                        focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                    modifier = Modifier
                        .width(320.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                OutlinedButton(
                    onClick = {
                        // TODO google auth
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(320.dp)
                        .height(52.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_google),
                                contentDescription = null,
                                modifier = Modifier,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Sign Up with Google",
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.size(8.dp))
                OutlinedButton(
                    onClick = {
                       //TODO viewModel.loginUser(email = userEmail, password = userPassword)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(256.dp)
                        .height(52.dp)
                ) {
                    Text(
                        text = "Log in",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
//                    if (state.value?.isLoading == true) {
//                        CircularProgressIndicator(
//                            color = MaterialTheme.colorScheme.onPrimary
//                        )
//                        Spacer(modifier = Modifier.height(4.dp))
//                    }
                }
                Row(
                    modifier = Modifier.width(256.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Account already exists?",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    TextButton(onClick = {
//                        TODO navController.navigate(Screen.)
                    }) {
                        Text(
                            text = "Log in",
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
        }
    }
}

//@Preview
//@Composable
//private fun PreviewSignUp() {
//    TYB2Theme {
//        SignUpScreen()
//    }
//}