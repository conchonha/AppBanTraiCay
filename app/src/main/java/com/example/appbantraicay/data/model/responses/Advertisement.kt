package com.example.appbantraicay.data.model.responses

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Advertisement {
    @SerializedName("HinhAnh")
    @Expose
    var image: String? = null

    @SerializedName("NoiDung")
    @Expose
    var content: String? = null

    @SerializedName("Id_Sanpham")
    @Expose
    var idProduct: Int? = null

    @SerializedName("TenSanPham")
    @Expose
    var nameProduct: String? = null

    @SerializedName("HinhAnhSanPham")
    @Expose
    var imageProduct: String? = null

    @SerializedName("Id")
    @Expose
    var id: Int? = null
}