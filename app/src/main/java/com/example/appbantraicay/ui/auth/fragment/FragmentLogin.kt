package com.example.appbantraicay.ui.auth.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentLoginBinding
import com.example.appbantraicay.ui.auth.viewmodel.LoginViewModel
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.androidlibrary.utils.Validator.isEmailValid
import com.sangtb.androidlibrary.utils.Validator.isPasswordValid
import com.sangtb.androidlibrary.utils.Validator.isValid
import com.sangtb.androidlibrary.utils.Validator.validate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentLogin : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_login
    override val viewModel: LoginViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.action = viewModel

        initValidation()
    }

    private fun initValidation() {
        binding.apply {
            val listTextInput = listOf(
                edtEmail.validate(listOf(::isEmailValid)),
                edtPassword.validate(listOf(::isPasswordValid))
            )

            btnLogin.setOnClickListener {
                if (listTextInput.isValid()) {
                    viewModel.loginUser()
                }
            }

            txtForgetPass.setOnClickListener {
                if(listTextInput.dropLast(INDEX_1).isValid()){
                    viewModel.showDialogVerifyEmail(childFragmentManager)
                }
            }
        }
    }

    companion object{
        private const val INDEX_1 = 1
    }
}