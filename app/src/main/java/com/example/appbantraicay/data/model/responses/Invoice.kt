package com.example.appbantraicay.data.model.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

data class Invoice(
    @SerializedName("Id_DonHang")
    @Expose
    private var idOrder : Int? = 0,

    @SerializedName("NgayDat")
    @Expose
    private var dateBooking : String = "",

    @SerializedName("TrinhTrang")
    @Expose
    private var status : String? = "",

    @SerializedName("Id_TaiKhoan")
    @Expose
    private var idUser : Int? = 0,

    @SerializedName("Id")
    @Expose
    private var id : Int? = 0,

    @SerializedName("Username")
    @Expose
    private var userName : String? = "",

    @SerializedName("Dia_Chi")
    @Expose
    private var address : String? = "",

    @SerializedName("Email")
    @Expose
    private var email : String? = "",

    @SerializedName("SoDienThoai")
    @Expose
    private var phoneNumber : String? = "",

    @SerializedName("Id_SanPham")
    @Expose
    private var idProduct : Int? = 0,

    @SerializedName("GiaSanPham")
    @Expose
    private var priceProduct : Int ? = 0,

    @SerializedName("HinhSanPham")
    @Expose
    private var imageProduct : String? = "",

    @SerializedName("SoLuongSanPham")
    @Expose
    private var numberProduct : Int? = 0,

    @SerializedName("TenSanPham")
    @Expose
    private var nameProduct : String? = "",

    @SerializedName("Id_DonDatHang")
    @Expose
    private val idTheOrder: Int? = 0,
)

