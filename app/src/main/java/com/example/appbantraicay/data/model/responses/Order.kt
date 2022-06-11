package com.example.appbantraicay.data.model.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("Id_DonHang")
    @Expose
    var idOrder: Int? = null,

    @SerializedName("NgayDat")
    @Expose
    var dateBooking: String? = null,

    @SerializedName("TrinhTrang")
    @Expose
    var status: String? = null,

    @SerializedName("Id_TaiKhoan")
    @Expose
    var idUser: Int? = null,
)