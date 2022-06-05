package com.example.appbantraicay.data.model.body;

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/29/2022
*/

data class UpdateCartBody(
    @SerializedName("idsanpham")
    @Expose
    var idProduct:  String ? = "",

    @SerializedName("soluong")
    @Expose
    var numberProduct :  Int ?= 0,

    @SerializedName("thanhtien")
    @Expose
    var price :  Int ?= 0,
)
