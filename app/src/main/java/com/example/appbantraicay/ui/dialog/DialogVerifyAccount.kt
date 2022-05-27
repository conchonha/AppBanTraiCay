package com.example.appbantraicay.ui.dialog;

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.DialogVerifyAccountBinding
import com.example.appbantraicay.ui.auth.viewmodel.LoginViewModel
import com.example.appbantraicay.utils.Validator.isValid
import com.example.appbantraicay.utils.showToast
import com.sangtb.androidlibrary.utils.DialogLibrary
import dagger.hilt.android.AndroidEntryPoint

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/27/2022
*/

@AndroidEntryPoint
public class DialogVerifyAccount : DialogLibrary<DialogVerifyAccountBinding>() {
    override val layout: Int
        get() = R.layout.dialog_verify_account

   override val viewModel by activityViewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            action = viewModel

            Log.d(TAG, "onViewCreated: ${viewModel.email.value}")
            btnSend.setOnClickListener {
                if(listOf(Pair(editTextCode,true)).isValid()){
                    viewModel.sendCodeVerifyEmail()
                    return@setOnClickListener
                }
                requireContext().showToast(R.string.incorrect_code)
            }
        }
    }

    fun show(fragmentManager: FragmentManager) {
        show(fragmentManager,TAG)
    }

    companion object{
        private const val TAG = "DialogVerifyAccount"
    }
}
