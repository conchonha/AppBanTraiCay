package com.example.appbantraicay.data.repository;

import androidx.lifecycle.LiveData
import com.example.appbantraicay.data.model.responses.Advertisement
import com.example.appbantraicay.data.model.responses.Category
import com.example.appbantraicay.data.model.responses.ProductNew

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
interface IActionRepository {
    val listAdvertisement : LiveData<List<Advertisement>>
    val listProductCategory : LiveData<List<Pair<Category?,List<ProductNew>?>>>

    fun insertCart(idUser: Int, idProduct: Int, price: Int)
}
