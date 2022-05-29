package com.example.appbantraicay.data.model.body;

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/29/2022
*/
data class PostCartBody(
    @SerializedName("iduser")
    @Expose
    var idUser :  Int ? = 0,

    @SerializedName("idsanpham")
    @Expose
    var idProduct :  Int ?= 0,

    @SerializedName("giasp")
    @Expose
    var price :  Int ?= 0,
)
