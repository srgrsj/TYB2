package com.example.tyb2.presentation.components

import android.graphics.drawable.Drawable
import com.example.tyb2.R

sealed class Screen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Main : Screen(
        route = "main_screen",
        title = "Main",
        icon = R.drawable.main_icon
    )

    object Collection : Screen(
        route = "collection_screen",
        title = "Collection",
        icon = R.drawable.collection_icon
    )

    object Profile : Screen(
        route = "profile_screen",
        title = "Profile",
        icon = R.drawable.profile_icon
    )

    companion object {
        // For detail screens
    }
}