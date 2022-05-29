package com.example.appbantraicay.data.model.responses;

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/29/2022
*/
data class Cart(
    @SerializedName("Id")
    @Expose
     var id: Int? = null,

    @SerializedName("Id_User")
    @Expose
     val idUser: Int? = null,

    @SerializedName("Id_Sanpham")
    @Expose
     val idProduct: String? = null,

    @SerializedName("Ten_Sanpham")
    @Expose
     val nameProduct: String? = null,

    @SerializedName("SoLuong")
    @Expose
     val number: Int? = null,

    @SerializedName("ThanhTien")
    @Expose
     val totalPrice: Int? = null,

    @SerializedName("Hinh")
    @Expose
     val image: String? = null
)
