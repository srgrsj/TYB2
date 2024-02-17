package com.example.tyb2.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tyb2.R

@Composable
fun NavBar(
    navController: NavController
) {
    var selectedItemRoute by rememberSaveable {
        mutableStateOf(NavConstants.MAIN)
    }

    val listItems = listOf(
        NavBarItem(
            iconId = R.drawable.store,
            route = NavConstants.STORE,
        ),
        NavBarItem(
            iconId = R.drawable.fire,
            route = NavConstants.MAIN,
        ),
        NavBarItem(
            iconId = R.drawable.profile,
            route = NavConstants.PROFILE,
        )

    )

    NavigationBar(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.onBackground)
            .height(56.dp)
    ) {
        listItems.forEach { item ->
            NavigationBarItem(
                selected = selectedItemRoute == item.route,
                onClick = {
                    selectedItemRoute = item.route
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            )
        }

    }

}
