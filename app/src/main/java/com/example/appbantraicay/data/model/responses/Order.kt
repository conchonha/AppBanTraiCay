package com.example.appbantraicay.data.model.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("Id_DonHang")
    @Expose
    var idDonHang: Int? = null,

    @SerializedName("NgayDat")
    @Expose
    var ngayDat: String? = null,

    @SerializedName("TrinhTrang")
    @Expose
    var trinhTrang: String? = null,

    @SerializedName("Id_TaiKhoan")
    @Expose
    var idTaiKhoan: Int? = null,
)