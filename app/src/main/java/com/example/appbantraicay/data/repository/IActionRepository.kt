package com.example.appbantraicay.data.repository;

import androidx.lifecycle.LiveData
import com.example.appbantraicay.data.model.body.PayCartBody
import com.example.appbantraicay.data.model.responses.*
import com.sangtb.androidlibrary.utils.SingleLiveEvent
import com.example.appbantraicay.data.model.body.PostCartBody
import com.example.appbantraicay.data.model.body.UpdateCartBody
import com.example.appbantraicay.data.model.responses.Advertisement
import com.example.appbantraicay.data.model.responses.Cart
import com.example.appbantraicay.data.model.responses.Category
import com.example.appbantraicay.data.model.responses.ProductNew

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
interface IActionRepository {
    val listAdvertisement : LiveData<List<Advertisement>>
    val listProductCategory : LiveData<List<Pair<Category?,List<ProductNew>?>>>
    val listCart : LiveData<List<Cart>>
    val listDataUser: LiveData<List<User>>
    val listDataProduct: LiveData<List<DataProduct>>
    val listDataOrderTransportting: LiveData<List<Order>>
    val listDataOrderDeleted: LiveData<List<Order>>
    val listDataOrderSuccess: LiveData<List<Order>>
    val listDataOrderApproving: LiveData<List<Order>>
    val listDataNews : LiveData<List<New>>
    val listOderWaitingApproval : LiveData<List<Order>>

    fun getDataCartFromIdUser(id: Int?)
    fun insertCart(postCartBody: PostCartBody,onSuccess: (String)->Unit)
    fun getDataProductFromIdBanner(id : String?,onSuccess: (ProductNew)->Unit)
    fun updateCart(updateCartBody: UpdateCartBody, idUser : Int?, onSuccess: (String) -> Unit)
    fun removeCartItem(idProduct : String?, idUser : Int?,onSuccess: (String) -> Unit)
    fun getDataWaitingForApproval()
    fun payCart(payCartBody: PayCartBody, idUser: Int?, onSuccess: (String) -> Unit)
    fun getDataBeingAndTransported()
    fun getDataDelivered()
    fun getDataCanceled()
}
