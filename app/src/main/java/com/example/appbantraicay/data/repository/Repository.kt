package com.example.appbantraicay.data.repository;

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appbantraicay.data.model.responses.Advertisement
import com.example.appbantraicay.data.model.responses.Category
import com.example.appbantraicay.data.model.responses.ProductNew
import com.example.appbantraicay.data.services.ApiServices
import com.sangtb.androidlibrary.base.data.repository.BaseRepository
import javax.inject.Inject
import javax.inject.Singleton

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/


@Singleton
class Repository @Inject constructor(private val apiServices: ApiServices) :
    DefaultLifecycleObserver, IActionRepository, BaseRepository() {
    private val _listAdvertisement = MutableLiveData<List<Advertisement>>()
    override val listAdvertisement: LiveData<List<Advertisement>> = _listAdvertisement

    private val _listProductCategory = MutableLiveData<List<Pair<Category?, List<ProductNew>?>>>()
    override val listProductCategory: LiveData<List<Pair<Category?, List<ProductNew>?>>> = _listProductCategory

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        callApi {
            //get List Quảng Cáo
            _listAdvertisement.postValue(apiServices.getDataAdvertisement())

            //get List Category and listProduct
            val pairList = mutableListOf<Pair<Category?, List<ProductNew>?>>()
            pairList.add(Pair(Category(id = -1), apiServices.getDataProductNew()))

            // get list Category
            apiServices.getDataCategory().forEach { category ->
                pairList.add(
                    Pair(
                        category,
                        apiServices.getDataProductCategory(category.id.toString())
                    )
                )
                _listProductCategory.postValue(pairList.toMutableList())
            }
        }
    }

    override fun insertCart(idUser: Int, idProduct: Int, price: Int) {
        callApi {
//            apiServices.insertCart(idUser, idProduct, price)
        }
    }

    override fun getDataProductFromIdBanner(id: String?, onSuccess: (ProductNew) -> Unit) {
        callApi {
            onSuccess.invoke(apiServices.getDataProductFromIdBanner(id))
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        cancelCoroutine()
        super.onDestroy(owner)
    }

    companion object {
        private const val TAG = "Repository"
    }
}
