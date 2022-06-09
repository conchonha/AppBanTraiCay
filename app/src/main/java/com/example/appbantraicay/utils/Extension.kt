package com.example.appbantraicay.utils;

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert.ACTION
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.appbantraicay.R
import com.example.appbantraicay.di.MainCoroutineScope
import com.google.gson.Gson
import com.sangtb.androidlibrary.base.AppEvent
import com.sangtb.androidlibrary.base.BaseViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
@BindingAdapter("setImageUrl")
fun setUrlImage(imageView: ImageView, src: String) {
    Picasso.get().load(src).error(R.drawable.img_error).into(imageView)
}

fun SharePrefs.checkUser() = get(SharePrefs.KEY_USER, String::class.java) != SharePrefs.EMPTY

fun Any.toJson(): String {
    return Gson().toJson(this)
}

fun <T>String.fromJSon(clazz: Class<T>): T? {
   return if(this != SharePrefs.EMPTY) Gson().fromJson(this,clazz) else null
}

fun Context.showToast(id : Int){
    Toast.makeText(this,getString(id),Toast.LENGTH_LONG).show()
}

fun Fragment.navigateDeepLink(uri: Int){
    NavDeepLinkRequest.Builder
        .fromUri(getString(uri).toUri())
        .build().let {
            findNavController().navigate(it)
        }
}
