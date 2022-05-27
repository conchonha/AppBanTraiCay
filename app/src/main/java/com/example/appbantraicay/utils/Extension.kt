package com.example.appbantraicay.utils;

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.viewModelScope
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

fun AppCompatActivity.setHideStatusBarAndControlBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}

fun Context.getNavigationBarHeight(): Int {
    val resources: Resources = this.resources
    val resourceId: Int = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else 0
}

fun Context.getStatusBarHeight(): Int {
    val resources: Resources = this.resources
    val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else 0
}

fun SharePrefs.checkUser() = get(SharePrefs.KEY_USER, String::class.java) != SharePrefs.EMPTY

fun Any.toJson(): String {
    return Gson().toJson(this)
}

fun Context.showToast(id : Int){
    Toast.makeText(this,getString(id),Toast.LENGTH_LONG).show()
}
