package com.example.appbantraicay.utils

import android.content.SharedPreferences
import com.example.appbantraicay.data.model.responses.User
import com.sangtb.androidlibrary.utils.SharePrefs
import javax.inject.Inject

class SharePrefs @Inject constructor(
    override val editor: SharedPreferences.Editor,
    override val sharedPref: SharedPreferences
) : SharePrefs(){

    fun getUserInfo() : User?{
       return get(KEY_USER, String::class.java).fromJSon(User::class.java)
    }

    fun saveUser(user: String){
        put(KEY_USER,user)
    }

    fun removeUser(){
        editor.clear().commit()
    }

    companion object{
        const val EMPTY = ""
        private const val FLOAT_DEFAULT = -1f
        const val KEY_USER = "KEY_USER"
    }
}