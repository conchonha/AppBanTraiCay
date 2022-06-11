package com.example.appbantraicay.ui.user.fragment.home.viewmodel;

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.body.PostCartBody
import com.example.appbantraicay.data.model.responses.ProductNew
import com.example.appbantraicay.data.repository.Repository
import com.example.appbantraicay.ui.user.interfaces.IActionItemAdapterHome
import com.example.appbantraicay.utils.Const.TYPE_DETAIL
import com.example.appbantraicay.utils.Const.TYPE_HOME
import com.example.appbantraicay.utils.SharePrefs
import com.example.appbantraicay.utils.checkUser
import com.sangtb.androidlibrary.base.BaseViewModel
import com.sangtb.androidlibrary.utils.combine
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
) : BaseViewModel(application), IActionItemAdapterHome {
    private val _productNew = MutableLiveData(ProductNew())
    val productNew: LiveData<ProductNew?> = _productNew

    val listProductCategory = repository.listProductCategory

    val listAdvertisement =
        _productNew.combine(repository.listAdvertisement) { product, advertisement ->
            return@combine if (product.description == null)
                advertisement.map { Pair(it.id, it.imageProduct) }
            else
                product.descriptionPicture?.split("@")?.map { Pair(-1, it) }
        }

    //home screen
    override fun onClickBuyCart(productNew: ProductNew) {
        _productNew.value = productNew
        checkUser(R.id.action_fragmentHome_to_login) {
            postDataCart{
                navigateToDestination(R.id.action_fragmentHome_to_fragmentCart)
            }
        }
    }

    override fun onClickDetail(product: ProductNew) {
        repository.getDataProductFromIdBanner(product.id.toString()) {
            _productNew.postValue(it)
            navigateToDestination(R.id.action_fragmentHome_to_fragmentDetail)
        }
    }

    fun bannerHomeClick(first: Int?, type: Int? = TYPE_HOME) {
        repository.getDataProductFromIdBanner(first.toString()) {
            _productNew.postValue(it)
            if (type == TYPE_DETAIL) return@getDataProductFromIdBanner
            navigateToDestination(R.id.action_fragmentHome_to_fragmentDetail)
        }
    }

    // screen detail
    fun onBuyNow() {
        checkUser {
            postDataCart{
                navigateToDestination(R.id.action_fragmentDetail_to_fragmentCart)
            }
        }
    }

    fun onSeeCart() {
        checkUser {
            navigateToDestination(R.id.action_fragmentDetail_to_fragmentCart)
        }
    }

    fun removeBannerDetail() {
        _productNew.postValue(ProductNew())
    }

    private fun postDataCart(method: ()->Unit) {
        sharePrefs.getUserInfo()?.let { user ->
            _productNew.value?.let {
                repository.insertCart(PostCartBody(user.id, it.id, it.price)) {
                    method.invoke()
                }
            }
            return
        }
        showToast(R.string.please_sign_in)
    }

    private fun checkUser(
        actionId: Int? = R.id.action_fragmentDetail_to_login,
        action: () -> Unit
    ) {
        if (sharePrefs.checkUser()) {
            action.invoke()
            return
        }
        navigateToDestination(actionId!!)
    }
}
