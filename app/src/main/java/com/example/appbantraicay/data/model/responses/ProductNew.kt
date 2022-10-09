package com.example.appbantraicay.data.model.responses;

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
    var nameProduct: String? = null,

    @SerializedName("HinhAnhSanPham")
    @Expose
    var image: String? = null,

    @SerializedName("Gia")
    @Expose
    var price: Int? = null,

    @SerializedName("NgayKhuyenMai")
    @Expose
    var discountDay: String? = null,

    @SerializedName("GiamGia")
    @Expose
    var numberDiscount: Int? = null,

    @SerializedName("DanhGiaSao")
    @Expose
    var evaluate: String? = null,

    @SerializedName("Loai")
    @Expose
    var type: String? = null,

    @SerializedName("HinhMoTa")
    @Expose
    var descriptionPicture: String? = null,

    @SerializedName("Mota")
    @Expose
    var description: String? = null,

    @SerializedName("SoLuong")
    @Expose
    var amount: Int? = null,

    @SerializedName("NgayDang")
    @Expose
    var dateSubmit: String? = null,

    @SerializedName("id_danhmuc")
    @Expose
    var idCategory: Int? = null
) {


    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return (other as? ProductNew)?.let {
            nameProduct == it.nameProduct
                    && discountDay == it.discountDay && numberDiscount == it.numberDiscount
                    && price == it.price && amount == it.amount && idCategory == it.idCategory
                    && dateSubmit == it.dateSubmit && description == it.description && descriptionPicture == it.descriptionPicture
        } ?: false
    }
}