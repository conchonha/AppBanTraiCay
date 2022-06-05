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
     var id: Int? = 0,

    @SerializedName("Id_User")
    @Expose
     val idUser: Int? = 0,

    @SerializedName("Id_Sanpham")
    @Expose
     val idProduct: String? = "",

    @SerializedName("Ten_Sanpham")
    @Expose
     val nameProduct: String? = "",

    @SerializedName("SoLuong")
    @Expose
     val number: Int? = 0,

    @SerializedName("ThanhTien")
    @Expose
     val totalPrice: Int? = 0,

    @SerializedName("Hinh")
    @Expose
     val image: String? = ""
)
