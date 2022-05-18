package com.example.appbantraicay.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SharePrefs @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val editor: SharedPreferences.Editor
)