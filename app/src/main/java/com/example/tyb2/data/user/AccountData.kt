package com.example.tyb2.data.user

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.tyb2.util.Constants
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object AccountData {
//    var ACCOUNT_AVATAR = R.drawable
    var EMAIL = Firebase.auth.currentUser?.email
    var ID = Firebase.auth.currentUser?.uid
}