package com.example.appbantraicay.data.model;

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/

data class ProductNew(
    @field:Expose @field:SerializedName("Id") var id: Int,
    @field:Expose @field:SerializedName(
        "TenSanPham"
    ) var tenSanPham: String,
    @field:Expose @field:SerializedName("HinhAnhSanPham") var hinhAnhSanPham: String,
    @field:Expose @field:SerializedName(
        "ThongSoKyThuat"
    ) var thongSoKyThuat: String,
    @field:Expose @field:SerializedName("Gia") var gia: Int,
    @field:Expose @field:SerializedName(
        "NgayKhuyenMai"
    ) var ngayKhuyenMai: String,
    @field:Expose @field:SerializedName("GiamGia") var giamGia: Int,
    @field:Expose @field:SerializedName(
        "DanhGiaSao"
    ) var danhGiaSao: String,
    @field:Expose @field:SerializedName("Loai") var loai: String
) {

    @SerializedName("id_danhmuc")
    @Expose
    var idDanhmuc: Int? = null

    override fun toString(): String {
        return "id: $id \n tenSanPham: $tenSanPham \n thongSoKyThuat: $thongSoKyThuat\n ngayKhuyenMai: $ngayKhuyenMai \n danhGiaSao: $danhGiaSao"
    }
}