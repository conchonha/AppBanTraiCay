package com.example.appbantraicay.data.repository;

import androidx.lifecycle.LiveData
import com.example.appbantraicay.data.model.responses.*
import com.sangtb.androidlibrary.utils.SingleLiveEvent

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
interface IActionRepository {
    //    val loadingDialog : SingleLiveEvent<Boolean>
    val listAdvertisement: LiveData<List<Advertisement>>

    //    val toastError : SingleLiveEvent<String>
    val listProductCategory: LiveData<List<Pair<Category?, List<ProductNew>?>>>

    val listDataUser: LiveData<List<User>>

    val listDataProduct: LiveData<List<DataProduct>>

    val listDataOrderTransportting: LiveData<List<Order>>
    val listDataOrderDeleted: LiveData<List<Order>>
    val listDataOrderSuccess: LiveData<List<Order>>
    val listDataOrderApproving: LiveData<List<Order>>

    val listDataNews : LiveData<List<New>>

    fun insertCart(idUser: Int, idProduct: Int, price: Int)
    fun getDataProductFromIdBanner(id : String?,onSuccess: (ProductNew)->Unit)
}
