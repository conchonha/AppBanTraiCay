package com.example.appbantraicay.data.model.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataProduct(
    @SerializedName("Id")
    @Expose
    var id: Int = 0,
    @Expose
    @SerializedName(
        "TenSanPham"
    ) var tenSanPham: String,
    @Expose
    @SerializedName("HinhAnhSanPham") var hinhAnhSanPham: String,

    @Expose
    @SerializedName("Gia") var gia: Int,
    @Expose
    @SerializedName(
        "NgayKhuyenMai"
    ) var ngayKhuyenMai: String,
    @Expose
    @SerializedName("GiamGia") var giamGia: Int,
    @Expose
    @SerializedName(
        "DanhGiaSao"
    ) var danhGiaSao: String,
    @Expose
    @SerializedName("Loai") var loai: String,
    @Expose
    @SerializedName("id_danhmuc") var idDanhmuc: Int? = null
)