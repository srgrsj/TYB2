package com.example.tyb2.util

import com.example.tyb2.R

fun getUserAvatar(g: String): Int {
    return when (g) {
        "m" -> R.drawable.profile_avatar_man
        "w" -> R.drawable.profile_avatar_woman
        else -> R.drawable.profile_avatar_default
    }
}