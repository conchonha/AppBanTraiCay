package com.example.appbantraicay.ui.user.fragment;

import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentCartBinding
import com.example.appbantraicay.ui.user.viewmodel.CartViewModel
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/27/2022
*/

@AndroidEntryPoint
public class FragmentCart : BaseFragment<FragmentCartBinding, CartViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_cart

    override val viewModel: CartViewModel by viewModels()
}
