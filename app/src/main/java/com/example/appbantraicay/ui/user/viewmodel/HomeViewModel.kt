package com.example.appbantraicay.ui.user.viewmodel;

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.appbantraicay.R
import com.example.appbantraicay.common.interfaces.IActionMenuHeader
import com.example.appbantraicay.data.model.responses.ProductNew
import com.example.appbantraicay.data.repository.Repository
import com.example.appbantraicay.ui.user.interfaces.IActionItemAdapter
import com.example.appbantraicay.utils.SharePrefs
import com.example.appbantraicay.utils.checkUser
import com.example.appbantraicay.utils.getStatusBarHeight
import com.sangtb.androidlibrary.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val repository: Repository,
    private val sharePrefs: SharePrefs
) : BaseViewModel(application), IActionMenuHeader {
    val heightStatusBar : LiveData<Int> = MutableLiveData(application.getStatusBarHeight())

    private val _productNew = MutableLiveData<ProductNew>()
    val productNew: LiveData<ProductNew>
        get() = _productNew

    val listProductCategory = repository.listProductCategory
    val listAdvertisement: LiveData<List<Pair<Int?, String?>>> =
        MediatorLiveData<List<Pair<Int?, String?>>>().apply {
            addSource(repository.listAdvertisement) { Advertisement ->
                value = Advertisement.map { Pair(it.id, it.imageProduct) }
            }

            addSource(_productNew) { product ->
                product.descriptionPicture?.split("@")?.map { Pair(-1, it) }?.let {
                    value = it
                }
            }
        }

    override fun onClickItemTitle(itemTitleId: Int) {
        Log.d(TAG, "onClickItemTitle Header Menu: ")
    }

    override val actionItemAdapter: IActionItemAdapter
        get() = object : IActionItemAdapter {
            //onBuyNow screen home
            override fun onClickBuyCart(productNew: ProductNew) {
                checkUser(R.id.action_fragmentHome_to_login){

                }
            }

            //onDetail screen home
            override fun onClickDetail(product: ProductNew) {
                _productNew.postValue(product)
                navigateToDestination(R.id.action_fragmentHome_to_fragmentDetail,null)
            }
        }

    //onBuyNow screen detail
    fun onBuyNow() {
        checkUser{
            navigateToDestination(R.id.action_fragmentDetail_to_fragmentCart,null)
        }
    }

    //onBuyNow screen detail
    fun onSeeCart() {
        checkUser{
            navigateToDestination(R.id.action_fragmentDetail_to_fragmentCart,null)
        }
    }

    private fun checkUser(actionId : Int? = R.id.action_fragmentDetail_to_login, action: ()->Unit){
        if(sharePrefs.checkUser()){
            action.invoke()
            return
        }
        navigateToDestination(actionId!!,null)
    }
}
