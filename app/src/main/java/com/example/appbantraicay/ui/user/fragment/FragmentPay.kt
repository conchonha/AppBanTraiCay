package com.example.appbantraicay.ui.user.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentPayBinding
import com.example.appbantraicay.ui.user.viewmodel.CartViewModel
import com.example.appbantraicay.utils.Const.KEY_STRIPPER
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.androidlibrary.utils.Validator
import com.sangtb.androidlibrary.utils.Validator.isValid
import com.sangtb.androidlibrary.utils.Validator.validate
import com.stripe.android.ApiResultCallback
import com.stripe.android.Stripe
import com.stripe.android.model.Card
import com.stripe.android.model.Token
import dagger.hilt.android.AndroidEntryPoint

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 6/5/2022
*/

@AndroidEntryPoint
class FragmentPay : BaseFragment<FragmentPayBinding,CartViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_pay
    override val viewModel: CartViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            action = viewModel

            val listTextInput = listOf(
                edtPhone.validate(listOf(Validator::isValidPhoneNumber)),
                edtAddress.validate(listOf(Validator::isValidAddress))
            )

            btnPay.setOnClickListener {
                val stripe = Stripe(requireActivity().applicationContext, KEY_STRIPPER)
                cardInput.card?.let {
                    stripe.createCardToken(it, callback = object : ApiResultCallback<Token> {
                        override fun onError(e: Exception) {
                            showToast(getString(R.string.stripper_is_incorrect),Toast.LENGTH_SHORT)
                        }

                        override fun onSuccess(result: Token) {
                            if(listTextInput.isValid()){
                                viewModel.pay()
                            }
                        }
                    })
                }
            }
        }

    }
}