package com.example.appbantraicay.ui.home.viewmodel;

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.appbantraicay.R
import com.example.appbantraicay.common.interfaces.IActionMenuHeader
import com.example.appbantraicay.data.model.Advertisement
import com.example.appbantraicay.data.model.ProductNew
import com.example.appbantraicay.data.repository.Repository
import com.example.appbantraicay.ui.home.adapter.IActionItemAdapter
import com.sangtb.androidlibrary.base.AppEvent
import com.sangtb.androidlibrary.base.BaseViewModel
import com.sangtb.androidlibrary.utils.combine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
) : BaseViewModel(application), IActionMenuHeader {
    private val _productNew = MutableLiveData<ProductNew>()
    val productNew: LiveData<ProductNew>
        get() = _productNew

    val listAdvertisement: LiveData<List<Pair<Int?, String?>>> =
        MediatorLiveData<List<Pair<Int?, String?>>>().apply {
            addSource(repository.listAdvertisement) { Advertisement ->
                value = Advertisement.map { Pair(it.id, it.hinhAnhSanPham) }
            }

            addSource(_productNew) { product ->
                product.hinhMoTa?.split("@")?.map { Pair(-1, it) }?.let {
                    value = it
                }
            }
        }

    val listProductCategory = repository.listProductCategory

    override fun onClickItemTitle(itemTitleId: Int) {
        Log.d(TAG, "onClickItemTitle Header Menu: ")
    }

    override val actionItemAdapter: IActionItemAdapter
        get() = object : IActionItemAdapter {
            override fun onClickBuyCart(productNew: ProductNew) {
                Log.d(TAG, "onClickBuyCart: ")
            }

            override fun onClickDetail(product: ProductNew) {
                _productNew.postValue(product)
                navigate(R.id.action_fragmentHome_to_fragmentDetail)
            }
        }

    private fun navigate(actionId : Int, bundle: Bundle? = null) {
        viewModelScope.launch {
            evenSender.send(AppEvent.OnNavigation(actionId))
        }
    }

    fun onBuyNow() {

    }

    fun onSeeCart() {
//        repository.insertCart()
    }

}
