package com.example.appbantraicay.ui.home.viewmodel;

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
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
    val listAdvertisement: LiveData<List<Advertisement>>
        get() = repository.listAdvertisement.combine(_productNew){listItem,product->
            if(product != null){
                val list = product.hin
            }
            listItem
        }

    val listProductCategory = repository.listProductCategory

    private val _productNew = MutableLiveData<ProductNew>()
    val productNew: LiveData<ProductNew>
        get() = _productNew

    override fun onClickItemTitle(itemTitleId: Int) {
        Log.d(TAG, "onClickItemTitle: ")
    }

    override val actionItemAdapter: IActionItemAdapter
        get() = object : IActionItemAdapter {
            override fun onClickBuyCart(productNew: ProductNew) {
                Log.d(TAG, "onClickBuyCart: ")
            }

            override fun onClickDetail(product: ProductNew) {
                _productNew.postValue(product)
                navigate()
            }
        }

    private fun navigate(bundle: Bundle? = null) {
        viewModelScope.launch {
            evenSender.send(AppEvent.OnNavigation(R.id.action_fragmentHome_to_fragmentDetail))
        }
    }

    fun onBuyNow() {

    }

    fun onSeeCart() {

    }

}
