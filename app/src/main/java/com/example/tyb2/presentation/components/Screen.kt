package com.example.tyb2.presentation.components

import com.example.tyb2.R

sealed class Screen(
//    selected: Boolean,
    val route: String,
    val title: String? = null,
    val icon: Int,
    val selectedIcon: Int,
) {
    object Main: Screen(
        route = "main_screen",
        icon = R.drawable.bottom_main_screen_icon,
        selectedIcon = R.drawable.bottom_field_main_screen_icon,
//        selected = false
    )

    object Activity: Screen(
        route = "activity_screen",
        icon = R.drawable.bottom_activity_screen_icon,
        selectedIcon = R.drawable.bottom_field_activity_screen_icon,
//        selected = false
    )

    object Profile: Screen(
        route = "profile_screen",
        icon = R.drawable.bottom_profile_screen_icon,
        selectedIcon = R.drawable.bottom_field_profile_screen_icon,
//        selected = false
    )

    companion object {
        const val ACHIEVEMENT_ROUTE = "achievements"
        const val BODY_FEATURES_ROUTE = "body_feature"
        const val CALENDAR_ROUTE = "calendar"
        const val PROFILE_SETTINGS = "profile_screen"
        const val SETTINGS = "settings"
    }
}