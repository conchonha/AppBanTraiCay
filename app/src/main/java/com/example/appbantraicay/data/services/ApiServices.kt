package com.example.appbantraicay.data.services;

import com.example.appbantraicay.data.model.body.LoginBody
import com.example.appbantraicay.data.model.body.NewPassBody
import com.example.appbantraicay.data.model.responses.Advertisement
import com.example.appbantraicay.data.model.responses.Category
import com.example.appbantraicay.data.model.responses.ProductNew
import com.example.appbantraicay.data.model.responses.User
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
}
