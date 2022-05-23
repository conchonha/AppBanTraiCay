package com.example.appbantraicay.data.repository;

import androidx.lifecycle.LiveData
import com.example.appbantraicay.data.model.Advertisement
import com.example.appbantraicay.data.model.Category
import com.example.appbantraicay.data.model.ProductNew
import com.sangtb.androidlibrary.utils.SingleLiveEvent

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
interface IActionRepository {
//    val loadingDialog : SingleLiveEvent<Boolean>
    val listAdvertisement : LiveData<List<Advertisement>>
//    val toastError : SingleLiveEvent<String>
    val listProductCategory : LiveData<List<Pair<Category?,List<ProductNew>?>>>

    fun insertCart(idUser: Int, idProduct: Int, price: Int)
}
