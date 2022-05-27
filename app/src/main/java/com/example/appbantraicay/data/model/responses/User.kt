package com.example.appbantraicay.data.model.responses;

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/26/2022
*/
data class User(
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("UserName")
    @Expose
    val userName: String? = null,

    @SerializedName("PassWord")
    @Expose
    val passWord: String? = null,

    @SerializedName("Email")
    @Expose
    val email: String? = null,

    @SerializedName("PhoneNumBer")
    @Expose
    val phoneNumBer: String? = null,

    @SerializedName("Adress")
    @Expose
    val address: String? = null,

    @SerializedName("Hinh")
    @Expose
    val image: String? = null,

    @SerializedName("loai")
    @Expose
    var type: Int? = null
)
