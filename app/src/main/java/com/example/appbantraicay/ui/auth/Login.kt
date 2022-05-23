package com.example.appbantraicay.ui.auth

import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentLoginBinding
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Login : BaseFragment<FragmentLoginBinding,AuthViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_login
    override val viewModel: AuthViewModel by viewModels()
}