package com.example.appbantraicay.data.services;

import com.example.appbantraicay.data.model.body.*
import com.example.appbantraicay.data.model.responses.*
import retrofit2.Call
import retrofit2.http.*

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/

interface ApiServices {
    @GET("model/quangcao/getdata")
    suspend fun getDataAdvertisement() : List<Advertisement>

    @GET("model/danhmuc/getdata")
    suspend fun getDataCategory(): List<Category>

    @FormUrlEncoded
    @POST("model/laptopmacbook/getdatalaptopmacbook")
    suspend fun getDataProductCategory(@Field("id") id: String): List<ProductNew>

    @GET("model/danhmuc/getdatalaptopmoinhat")
    suspend fun getDataProductNew(): List<ProductNew>

    @POST("model/login/dangnhap")
    suspend fun postLogin(@Body loginBody: LoginBody): List<User>

    @FormUrlEncoded
    @POST("model/taikhoan/checkEmail")
    suspend fun checkEmail(@Field("email") email : String) : String

    @POST("model/taikhoan/updatePasswordForEmail")
    suspend fun updatePasswordForEmail(@Body newPassBody: NewPassBody) : String

    @POST("model/taikhoan/dangkytaikhoan")
    suspend fun register(@Body registerBody: RegisterBody) : String

    @FormUrlEncoded
    @POST("model/sanpham/getdatasanphamchitiet")
    suspend fun getDataProductFromIdBanner(@Field("id") id: String?): ProductNew

    @FormUrlEncoded
    @POST("model/sanpham/getdataTimkiem")
    suspend fun searchProduct(@Field("timkim") search: String?): List<ProductNew>

    @POST("model/giohang/postgiohang")
    suspend fun postCart(
        @Body postCartBody: PostCartBody
    ): String

    @FormUrlEncoded
    @POST("model/giohang/getDataGioHangFromIdUser")
    suspend fun getDataCartFromIdUser(@Field("idUser") idUser : Int?) : List<Cart>

    @POST("model/giohang/updategiohang")
    suspend fun updateCart(
        @Body updateCartBody: UpdateCartBody
    ): String

    @FormUrlEncoded
    @POST("model/giohang/delete")
    suspend fun removeCartItem(@Field("idsanpham") idProduct: String?): String

    @POST("model/chitietdonhang/dondathang")
    suspend fun payCart(
      @Body payCartBody: PayCartBody
    ): String


    //API Data User Admin
    @GET("model/taikhoan/gettaikhoan")
    suspend fun getListDataUser(): List<User>

    @FormUrlEncoded
    @POST("model/laptopmacbook/getdatalaptopmacbook")
    suspend fun getDataProduct(@Field("id") id: String = "1"): List<DataProduct>

    @GET("model/dondathang/getdatadangvanchuyenadmin")
    suspend fun getDataOrderTransportting(): List<Order>

    @GET("model/dondathang/getdatadahuyadmin")
    suspend fun getDataOrderDeleted(): List<Order>

    @GET("model/dondathang/dagiaohangadmin")
    suspend fun getDataOrderSuccess(): List<Order>

    @GET("model/dondathang/choxetduyetadmin")
    suspend fun getDataOrderApproving(): List<Order>

    @GET("model/tintuc/getdatatintuc")
    suspend fun getDataNews(): List<New>
}
