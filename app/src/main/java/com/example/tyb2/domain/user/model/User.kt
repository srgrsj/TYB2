package com.example.tyb2.domain.user.model

import java.util.UUID

data class User(
    val email: String,
    val id: String = UUID.randomUUID().toString()
//    val avatar:

)