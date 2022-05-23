package com.example.appbantraicay.utils;

import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.viewModelScope
import com.example.appbantraicay.R
import com.sangtb.androidlibrary.base.AppEvent
import com.sangtb.androidlibrary.base.BaseViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
@BindingAdapter("setImageUrl")
fun setUrlImage(imageView: ImageView, src: String) {
    Picasso.get().load(src).error(R.drawable.img_error).placeholder(R.drawable.img_city)
        .into(imageView)
}
