package com.example.tyb2.util

import com.example.tyb2.R

sealed class Screen(
    val route: String,
    val title: String? = null,
    val icon: Int,
    val selectedIcon: Int,
) {
    object Main: Screen(
        route = "main_screen",
        icon = R.drawable.bottom_main_screen_icon,
        selectedIcon = R.drawable.bottom_field_main_screen_icon,
    )

    object Activity: Screen(
        route = "activity_screen",
        icon = R.drawable.bottom_activity_screen_icon,
        selectedIcon = R.drawable.bottom_field_activity_screen_icon,
    )

    object Profile: Screen(
        route = "profile_screen",
        icon = R.drawable.bottom_profile_screen_icon,
        selectedIcon = R.drawable.bottom_field_profile_screen_icon,
    )

    companion object {
        const val ACHIEVEMENT_ROUTE = "achievements_screen"
        const val BODY_FEATURES_ROUTE = "body_feature_screen"
        const val CALENDAR_ROUTE = "calendar_screen"
        const val PROFILE_SETTINGS = "profile_settings_screen"
        const val SETTINGS = "settings_screen"
        const val STORE = "store_screen"
        const val SIGN_UP = "sign_up_screen"
        const val SIGN_IN = "sign_in_screen"
        const val ONBOARDING = "onboarding_screen"
    }
}