package com.example.tyb2.util

fun String.limitToMaxLength(maxLength: Int): String {
    return if (length > maxLength) {
        substring(0, maxLength) + "..."
    } else {
        this
    }
}