package com.example.appbantraicay.data.model.body

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
* Copyright © 2022 UITS CO.,LTD
* Created by SangTB on 05/06/2022.
*/

data class PayCartBody(
    @SerializedName("idtaikhoan")
    @Expose
    var idUser:  String ? = "",

    @SerializedName("trinhtrang")
    @Expose
    var status:  String ? = "",

    @SerializedName("ngaydat")
    @Expose
    var date:  String ? = "",

    @SerializedName("username")
    @Expose
    var username:  String ? = "",

    @SerializedName("diachi")
    @Expose
    var address:  String ? = "",

    @SerializedName("email")
    @Expose
    var email:  String ? = "",

    @SerializedName("sodienthoai")
    @Expose
    var phoneNumber:  String ? = "",
)