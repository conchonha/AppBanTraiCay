package com.example.appbantraicay.ui.auth.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentRegisterBinding
import com.example.appbantraicay.ui.auth.viewmodel.RegisterViewModel
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.androidlibrary.utils.Validator
import com.sangtb.androidlibrary.utils.Validator.isEmailValid
import com.sangtb.androidlibrary.utils.Validator.isPasswordValid
import com.sangtb.androidlibrary.utils.Validator.isValid
import com.sangtb.androidlibrary.utils.Validator.isValidName
import com.sangtb.androidlibrary.utils.Validator.validate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentRegister : BaseFragment<FragmentRegisterBinding, RegisterViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_register
    override val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            action = viewModel

            val list = listOf(
                edtName.validate(listOf(::isValidName)),
                edtEmail.validate(listOf(::isEmailValid)),
                edtPassword.validate(listOf(::isPasswordValid))
            )

            btnRegister.setOnClickListener {
                if(list.isValid()){
                    viewModel.register()
                }
            }
        }
    }
}