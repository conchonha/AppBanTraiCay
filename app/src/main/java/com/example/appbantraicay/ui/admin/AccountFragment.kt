package com.example.appbantraicay.ui.admin

import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentAccountBinding
import com.sangtb.androidlibrary.base.BaseFragment

class AccountFragment : BaseFragment<FragmentAccountBinding, AccountViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_account

    override val viewModel: AccountViewModel by viewModels()
}