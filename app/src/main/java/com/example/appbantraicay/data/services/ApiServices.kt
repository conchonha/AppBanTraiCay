package com.example.appbantraicay.data.services;

import com.example.appbantraicay.data.model.body.LoginBody
import com.example.appbantraicay.data.model.body.NewPassBody
import com.example.appbantraicay.data.model.body.RegisterBody
import com.example.appbantraicay.data.model.responses.*
import retrofit2.Call
import retrofit2.http.*

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/

interface ApiServices {
    @GET("model/quangcao/getdata")
    suspend fun getDataAdvertisement(): List<Advertisement>

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
    suspend fun checkEmail(@Field("email") email: String): String

    @POST("model/taikhoan/updatePasswordForEmail")
    suspend fun updatePasswordForEmail(@Body newPassBody: NewPassBody): String

    //API Data User Admin
    @GET("model/taikhoan/gettaikhoan")
    suspend fun getListDataUser(): List<User>

    //API Product Admin
    @FormUrlEncoded
    @POST("model/laptopmacbook/getdatalaptopmacbook")
    fun getDataProduct(@Field("id") id: String = "1"): List<DataProduct>


    //API

    @GET("model/dondathang/getdatadangvanchuyenadmin")
    fun getDataOrderTransportting(): List<Order>

    @GET("model/dondathang/getdatadahuyadmin")
    fun getDataOrderDeleted(): List<Order>

    @GET("model/dondathang/dagiaohangadmin")
    fun getDataOrderSuccess(): List<Order>

    @GET("model/dondathang/choxetduyetadmin")
    fun getDataOrderApproving(): List<Order>

    @POST("model/taikhoan/dangkytaikhoan")
    suspend fun register(@Body registerBody: RegisterBody) : String

    @FormUrlEncoded
    @POST("model/sanpham/getdatasanphamchitiet")
    suspend fun getDataProductFromIdBanner(@Field("id") id: String?): ProductNew

    @FormUrlEncoded
    @POST("model/sanpham/getdataTimkiem")
    suspend fun searchProduct(@Field("timkim") search: String?): List<ProductNew>

    @GET("model/tintuc/getdatatintuc")
    fun getDataNews(): List<New>
}
