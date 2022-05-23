package com.example.appbantraicay.data.repository;

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    DefaultLifecycleObserver, IActionRepository {
    private var jog: Job? = null

    private val _listAdvertisement = MutableLiveData<List<Advertisement>>()
    override val listAdvertisement: LiveData<List<Advertisement>>
        get() = _listAdvertisement

    private val _listProductCategory = MutableLiveData<List<Pair<Category?, List<ProductNew>?>>>()
    override val listProductCategory: LiveData<List<Pair<Category?, List<ProductNew>?>>>
        get() = _listProductCategory

    override val toastError = SingleLiveEvent<String>()
    override val loadingDialog: SingleLiveEvent<Boolean> = SingleLiveEvent()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        loadingDialog.postValue(true)
        jog =
            CoroutineScope(Dispatchers.IO + SupervisorJob() + CoroutineExceptionHandler { _, throwable ->
                toastError.postValue(throwable.message)
            }).launch {
                //get List Quảng Cáo
                _listAdvertisement.postValue(apiServices.getDataAdvertisement())

                //get List Category and listProduct
                val pairList = mutableListOf<Pair<Category?,List<ProductNew>?>>()
                pairList.add(Pair(Category(id = -1),apiServices.getDataProductNew()))

                apiServices.getDataCategory().forEach {category->
                    pairList.add(Pair(category,apiServices.getDataProductCategory(category.id.toString())))
                    _listProductCategory.postValue(pairList.toMutableList())
                }

                loadingDialog.postValue(false)
            }

    }

    override fun onDestroy(owner: LifecycleOwner) {
        jog?.cancel()
        jog = null
        super.onDestroy(owner)
    }

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
        return withContext(Dispatchers.IO) {
            try {
                Result.success(apiCall.invoke())
            } catch (throwable: Throwable) {
                Log.d(TAG, "safeApiCall: ${throwable.message}")
                Result.failure(throwable)
            }
        }
    }

    companion object {
        private const val TAG = "Repository"
    }
}
