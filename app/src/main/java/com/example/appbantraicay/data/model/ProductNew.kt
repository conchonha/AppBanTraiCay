package com.example.appbantraicay.data.model;

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/

data class ProductNew(
    @SerializedName("Id") @Expose
    var id: Int? = null,

    @SerializedName("TenSanPham")
    @Expose
    var tenSanPham: String? = null,

    @SerializedName("HinhAnhSanPham")
    @Expose
    var hinhAnhSanPham: String? = null,

    @SerializedName("Gia")
    @Expose
    var gia: Int? = null,

    @SerializedName("NgayKhuyenMai")
    @Expose
    var ngayKhuyenMai: String? = null,

    @SerializedName("GiamGia")
    @Expose
    var giamGia: Int? = null,

    @SerializedName("DanhGiaSao")
    @Expose
    var danhGiaSao: String? = null,

    @SerializedName("Loai")
    @Expose
    var loai: String? = null,

    @SerializedName("HinhMoTa")
    @Expose
    var hinhMoTa: String? = null,

    @SerializedName("Mota")
    @Expose
    var mota: String? = null,

    @SerializedName("SoLuong")
    @Expose
    var soLuong: Int? = null,

    @SerializedName("NgayDang")
    @Expose
    var ngayDang: String? = null,

    @SerializedName("ThongSoKyThuat")
    @Expose
    var thongSoKyThuat: String? = null,

    @SerializedName("id_danhmuc") @Expose
    var idDanhmuc: Int? = null
) {


    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return (other as? ProductNew)?.let {
            tenSanPham == it.tenSanPham && thongSoKyThuat == it.thongSoKyThuat
                    && ngayKhuyenMai == it.ngayKhuyenMai && giamGia == it.giamGia
                    && gia == it.gia && soLuong == it.soLuong && idDanhmuc == it.idDanhmuc
                    && ngayDang == it.ngayDang && mota == it.mota && hinhMoTa == it.hinhMoTa
        } ?: false
    }
}