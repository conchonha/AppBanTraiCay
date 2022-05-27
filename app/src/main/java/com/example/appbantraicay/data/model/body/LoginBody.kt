package com.example.appbantraicay.data.model.body;

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/26/2022
*/
data class LoginBody(
    private var user: String? = null,
    private var pass: String? = null)
