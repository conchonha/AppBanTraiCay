package com.example.appbantraicay.data.repository;

import com.example.appbantraicay.data.model.Advertisement
import com.example.appbantraicay.data.model.Category
import com.example.appbantraicay.data.model.ProductNew
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

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

    @FormUrlEncoded
    @POST("model/giohang/postgiohang")
    suspend fun insertCart(
        @Field("iduser") idUser: Int,
        @Field("idsanpham") idProduct: Int,
        @Field("giasp") price: Int
    ): String
}
