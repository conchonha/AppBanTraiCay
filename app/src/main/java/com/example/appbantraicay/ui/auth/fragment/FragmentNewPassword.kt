package com.example.appbantraicay.ui.auth.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentNewPasswordBinding
import com.example.appbantraicay.ui.auth.viewmodel.LoginViewModel
import com.example.appbantraicay.ui.auth.viewmodel.NewPasswordViewModel
import com.example.appbantraicay.utils.Const
import com.example.appbantraicay.utils.Validator.isPasswordValid
import com.example.appbantraicay.utils.Validator.isValid
import com.example.appbantraicay.utils.Validator.validate
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/28/2022
*/

@AndroidEntryPoint
public class FragmentNewPassword : BaseFragment<FragmentNewPasswordBinding, NewPasswordViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_new_password
    override val viewModel: NewPasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            viewModel.setEmail(getString(Const.KEY_EMAIL,EMPTY))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = this.viewModel

            val list = listOf(
                edtPassword.validate(listOf(::isPasswordValid)),
                edtNewPassword.validate(listOf(::isPasswordValid))
            )

            btnAgree.setOnClickListener {
              if(list.isValid()){
                  viewModel?.onAgree()
              }
            }
        }
    }

    companion object{
        private const val EMPTY = ""
    }
}
