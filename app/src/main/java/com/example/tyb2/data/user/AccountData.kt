package com.example.tyb2.data.user

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object AccountData {
//    var ACCOUNT_AVATAR = R.drawable
    var EMAIL = Firebase.auth.currentUser?.email
    var ID = Firebase.auth.currentUser?.uid
}