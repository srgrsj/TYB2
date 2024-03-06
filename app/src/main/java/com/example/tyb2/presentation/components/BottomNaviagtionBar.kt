package com.example.tyb2.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {
    val screens = listOf(
        Screen.Main,
        Screen.Activity,
        Screen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    BottomAppBar(
        modifier = Modifier.height(52.dp),
        containerColor = MaterialTheme.colorScheme.onBackground,
        tonalElevation = 0.dp
    ) {
        screens.forEachIndexed {index, screen ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.2f),
                    indicatorColor = MaterialTheme.colorScheme.onBackground
                ),
                icon = {
                    Icon(
                        painter = if (index == selectedItemIndex) painterResource(screen.selectedIcon)
                        else painterResource(screen.icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(if (index == selectedItemIndex) 32.dp
                        else 24.dp
                        ))
                },
                selected = currentDestination?.hierarchy?.any{
                    it.route == screen.route
                } == true,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(screen.route){
                        popUpTo(screen.route) {
                            inclusive = true
                            saveState = true
                        }
                    }
                }
            )
        }
    }
}