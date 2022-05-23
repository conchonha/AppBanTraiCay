package com.example.appbantraicay.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SharePrefs @Inject constructor(
    private val sharedPref: SharedPreferences,
    private val editor: SharedPreferences.Editor
){
    private fun <T> put(key: String, data: T) {
        val editor = sharedPref.edit()

        when (data) {
            is String -> editor.putString(key, data)
            is Boolean -> editor.putBoolean(key, data)
            is Float -> editor.putFloat(key, data)
            is Double -> editor.putFloat(key, data.toFloat())
            is Int -> editor.putInt(key, data)
            is Long -> editor.putLong(key, data)
        }
        editor.apply()
    }

    private fun <T> get(key: String, clazz: Class<T>): T =
        when (clazz) {
            String::class.java -> sharedPref.getString(key, EMPTY)
            Boolean::class.java -> sharedPref.getBoolean(key, false)
            Float::class.java -> sharedPref.getFloat(key, FLOAT_DEFAULT)
            Double::class.java -> sharedPref.getFloat(key, FLOAT_DEFAULT)
            Int::class.java -> sharedPref.getInt(key, -1)
            Long::class.java -> sharedPref.getLong(key, -1L)
            else -> null
        } as T

    private companion object{
        private const val EMPTY = ""
        private const val FLOAT_DEFAULT = -1f
    }
}