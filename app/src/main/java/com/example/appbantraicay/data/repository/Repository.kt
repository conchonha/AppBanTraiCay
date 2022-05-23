package com.example.appbantraicay.data.repository;

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appbantraicay.common.BaseRepository1
import com.example.appbantraicay.data.model.Advertisement
import com.example.appbantraicay.data.model.Category
import com.example.appbantraicay.data.model.ProductNew
import com.sangtb.androidlibrary.utils.SingleLiveEvent
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Singleton

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/


@Singleton
class Repository @Inject constructor(private val apiServices: ApiServices) :
    DefaultLifecycleObserver, IActionRepository, BaseRepository1() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
        toastManager.errorThrowable.postValue(throwable)
        toastManager.loadingDialog.postValue(false)
    })
    private var jog : Job? = null

    private val _listAdvertisement = MutableLiveData<List<Advertisement>>()
    override val listAdvertisement: LiveData<List<Advertisement>>
        get() = _listAdvertisement

    private val _listProductCategory = MutableLiveData<List<Pair<Category?, List<ProductNew>?>>>()
    override val listProductCategory: LiveData<List<Pair<Category?, List<ProductNew>?>>>
        get() = _listProductCategory

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
//        loadingDialog.postValue(true)
        jog = coroutineScope.launch {
          safeApiCall({apiServices.getDataAdvertisement()},{apiServices.getDataProductNew()},{apiServices.getDataCategory()})?.let {
              Log.d("SangTB", "onCreate ABC: $it")
          }

//            //get List Quảng Cáo
//            Log.d(TAG, "onCreate0: ")
//            _listAdvertisement.postValue(apiServices.getDataAdvertisement())
//
//            Log.d(TAG, "onCreate1: ")
//            //get List Category and listProduct
//            val pairList = mutableListOf<Pair<Category?, List<ProductNew>?>>()
//            pairList.add(Pair(Category(id = -1), apiServices.getDataProductNew()))
//
//            Log.d(TAG, "onCreate2: ")
//            // get list Category
//            apiServices.getDataCategory().forEach { category ->
//                pairList.add(
//                    Pair(
//                        category,
//                        apiServices.getDataProductCategory(category.id.toString())
//                    )
//                )
//                _listProductCategory.postValue(pairList.toMutableList())
//            }
//
//            Log.d(TAG, "onCreate3: ")
//            loadingDialog.postValue(false)
        }
    }

    override fun insertCart(idUser: Int, idProduct: Int, price: Int) {
        jog = coroutineScope.launch {
            apiServices.insertCart(idUser,idProduct,price)
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        jog?.cancel()
        jog = null
        super.onDestroy(owner)
    }

    companion object {
        private const val TAG = "Repository"
    }
}
