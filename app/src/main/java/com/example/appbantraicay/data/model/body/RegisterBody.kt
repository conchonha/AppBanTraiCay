package com.example.appbantraicay.data.model.body;

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/28/2022
*/
data class RegisterBody(
    @SerializedName("username")
    @Expose
    var userName: String? = "",

    @SerializedName("password")
    @Expose
    var password: String? = "",

    @SerializedName("email")
    @Expose
    var email: String? = "",

    @SerializedName("idloai")
    @Expose
    var typeId: Int? = 0,
)
