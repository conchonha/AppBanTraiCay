package com.example.appbantraicay.utils;

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.appbantraicay.R

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
@BindingAdapter("setImageUrl")
fun setUrlImage(imageView: ImageView, src: String) {
    P.with(imageView.context).load(src).error(R.drawable.img_error).placeholder(R.drawable.img_city)
        .into(imageView)
}
