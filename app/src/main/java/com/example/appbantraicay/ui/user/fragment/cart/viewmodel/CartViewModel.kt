package com.example.appbantraicay.ui.user.fragment.cart.viewmodel;

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.body.PayCartBody
import com.example.appbantraicay.data.model.body.UpdateCartBody
import com.example.appbantraicay.data.model.responses.Cart
import com.example.appbantraicay.data.repository.Repository
import com.example.appbantraicay.ui.user.interfaces.IActionItemAdapterCart
import com.example.appbantraicay.utils.Const.STATUS_CART
import com.example.appbantraicay.utils.SharePrefs
import com.sangtb.androidlibrary.base.BaseViewModel
import com.sangtb.androidlibrary.utils.getNavigationBarHeight
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/27/2022
*/
@HiltViewModel
public class CartViewModel @Inject constructor(
    application: Application,
    private val repository: Repository,
    private val sharePrefs: SharePrefs
) : BaseViewModel(application), IActionItemAdapterCart {
    private val user = sharePrefs.getUserInfo()
    val height: LiveData<Int> = MutableLiveData(application.getNavigationBarHeight())
    val listCart = repository.listCart
    val totalPrice: LiveData<Float> = Transformations.map(listCart) { list ->
        var total = 0.0F
        list.forEach {
            total += it.totalPrice!!
        }
        total
    }

    val email: LiveData<String?> = MutableLiveData(user?.email)
    val userName: LiveData<String?> = MutableLiveData(user?.userName)
    val phoneNumber = MutableLiveData<String>()
    val address = MutableLiveData<String>()

    fun payNow() = navigateToDestination(R.id.action_fragmentCart_to_fragmentPay)

    override fun plus(cart: Cart) {
        if (cart.number != 0) {
            updateCart(cart)
        }
    }

    override fun minus(cart: Cart) {
        if (cart.number!! > INDEX_1) {
            updateCart(cart, true)
            return
        }
        showToast(R.string.number_product_reached_minimum)
    }

    override fun remove(cart: Cart) {
        repository.removeCartItem(cart.idProduct, user?.id) {
            showToast(R.string.remove_success)
        }
    }

    fun pay() {
        repository.payCart(
            PayCartBody(
                user?.id.toString(), STATUS_CART, SimpleDateFormat("yyyy-MM-dd").format(
                    Date()
                ), userName.value, address.value, email.value, phoneNumber.value
            ), user?.id
        ) {
            showToast(R.string.pay_success)
        }
    }

    private fun updateCart(cart: Cart, checkGiam: Boolean = false) {
        repository.updateCart(
            UpdateCartBody(
                cart.idProduct,
                if (checkGiam) cart.number!! - INDEX_1 else cart.number!! + INDEX_1,
                if (checkGiam)
                    (cart.totalPrice!! - (cart.totalPrice / cart.number))
                else
                    (cart.totalPrice!! + (cart.totalPrice / cart.number))
            ), user?.id
        ) {
            showToast(R.string.update_success)
        }
    }

    companion object {
        private const val INDEX_1 = 1
    }
}
