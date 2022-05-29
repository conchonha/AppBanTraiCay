package com.example.appbantraicay.data.repository;

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appbantraicay.data.model.body.PostCartBody
import com.example.appbantraicay.data.model.responses.Advertisement
import com.example.appbantraicay.data.model.responses.Cart
import com.example.appbantraicay.data.model.responses.Category
import com.example.appbantraicay.data.model.responses.ProductNew
import com.example.appbantraicay.data.model.responses.*
import com.example.appbantraicay.data.services.ApiServices
import com.example.appbantraicay.utils.SharePrefs
import com.sangtb.androidlibrary.base.data.repository.BaseRepository
import javax.inject.Inject
import javax.inject.Singleton

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/


@Singleton
class Repository @Inject constructor(
    private val apiServices: ApiServices,
    private val sharePrefs: SharePrefs
) :
    DefaultLifecycleObserver, IActionRepository, BaseRepository() {
    private val _listAdvertisement = MutableLiveData<List<Advertisement>>()
    override val listAdvertisement: LiveData<List<Advertisement>> = _listAdvertisement

    private val _listProductCategory = MutableLiveData<List<Pair<Category?, List<ProductNew>?>>>()
    override val listProductCategory: LiveData<List<Pair<Category?, List<ProductNew>?>>> = _listProductCategory

    private val _listCart = MutableLiveData<List<Cart>>()
    override val listCart: LiveData<List<Cart>> = _listCart

    private val _listDataUser = MutableLiveData<List<User>>()
    override val listDataUser: LiveData<List<User>>
        get() = _listDataUser

    private val _listDataProduct = MutableLiveData<List<DataProduct>>()
    override val listDataProduct: LiveData<List<DataProduct>>
        get() = _listDataProduct

    private val _listDataOrderTransportting =  MutableLiveData<List<Order>>()
    override val listDataOrderTransportting: LiveData<List<Order>>
        get() = _listDataOrderTransportting

    private val _listDataOrderDeleted = MutableLiveData<List<Order>>()
    override val listDataOrderDeleted: LiveData<List<Order>>
        get() =_listDataOrderDeleted

    private val _listDataOrderSuccess = MutableLiveData<List<Order>>()
    override val listDataOrderSuccess: LiveData<List<Order>>
        get() = _listDataOrderSuccess

    private val _listDataOrderApproving = MutableLiveData<List<Order>>()
    override val listDataOrderApproving: LiveData<List<Order>>
        get() = _listDataOrderApproving

    private val _listDataNews = MutableLiveData<List<New>>()
    override val listDataNews: LiveData<List<New>>
        get() = _listDataNews

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

            sharePrefs.getUserInfo()?.let {
                getDataCartFromIdUser(it.id)
            }

            // get list data  user

            mutableListOf<User>().let {
                it.addAll(apiServices.getListDataUser())
                _listDataUser.postValue(it)
            }

            //get list data product
            mutableListOf<DataProduct>().let {
                it.addAll(apiServices.getDataProduct())
                _listDataProduct.postValue(it)
            }

            mutableListOf<Order>().let {
                it.addAll(apiServices.getDataOrderTransportting())
                _listDataOrderTransportting.postValue(it)
            }

            mutableListOf<Order>().let {
                it.addAll(apiServices.getDataOrderApproving())
                _listDataOrderApproving.postValue(it)
            }

            mutableListOf<Order>().let {
                it.addAll(apiServices.getDataOrderDeleted())
                _listDataOrderDeleted.postValue(it)
            }

            mutableListOf<Order>().let {
                it.addAll(apiServices.getDataOrderSuccess())
                _listDataOrderSuccess.postValue(it)
            }

            mutableListOf<New>().let {
                it.addAll(apiServices.getDataNews())
                _listDataNews.postValue(it)
            }
        }
    }

    override fun insertCart(postCartBody: PostCartBody, onSuccess: (String) -> Unit) {
        callApi {
            onSuccess.invoke(apiServices.postCart(postCartBody))
            getDataCartFromIdUser(postCartBody.idUser)
        }
    }

    override fun getDataCartFromIdUser(id: Int?){
        callApi {
            _listCart.postValue(apiServices.getDataCartFromIdUser(id))
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
