package com.example.appbantraicay.ui.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.DialogPayWhenMultiplyingBinding
import com.example.appbantraicay.ui.user.fragment.cart.viewmodel.CartViewModel
import com.sangtb.androidlibrary.utils.DialogLibrary
import com.sangtb.androidlibrary.utils.Validator
import com.sangtb.androidlibrary.utils.Validator.isValid
import com.sangtb.androidlibrary.utils.Validator.validate
import dagger.hilt.android.AndroidEntryPoint

/*
* Copyright © 2022 UITS CO.,LTD
* Created by SangTB on 11/06/2022.
*/

@AndroidEntryPoint
class DialogWhenMultiplying : DialogLibrary<DialogPayWhenMultiplyingBinding>(){
    override val layout: Int
        get() = R.layout.dialog_pay_when_multiplying

    override val viewModel by activityViewModels<CartViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            action = viewModel

            val listTextInput = listOf(
                edtPhone.validate(listOf(Validator::isValidPhoneNumber)),
                edtAddress.validate(listOf(Validator::isValidAddress))
            )

            btnSend.setOnClickListener {
                if(listTextInput.isValid()){
                    viewModel.pay()
                }
            }
        }
    }
}