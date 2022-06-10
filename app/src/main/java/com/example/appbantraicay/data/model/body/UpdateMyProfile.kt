package com.example.appbantraicay.data.model.body

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
* Copyright © 2022 UITS CO.,LTD
* Created by SangTB on 10/06/2022.
*/

data class UpdateMyProfile(
    @SerializedName("username")
    @Expose
    private val userName: String? = "",

    @SerializedName("sodienthoai")
    @Expose
    private val phoneNumber: String? = "",

    @SerializedName("email")
    @Expose
    private val email: String? = "",

    @SerializedName("idtaikhoan")
    @Expose
    private val idUser: String? = "",

    )