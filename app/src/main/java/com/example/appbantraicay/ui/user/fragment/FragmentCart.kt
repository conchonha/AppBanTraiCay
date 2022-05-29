package com.example.appbantraicay.ui.user.fragment;

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentCartBinding
import com.example.appbantraicay.ui.user.adapter.RecyclerAdapterCart
import com.example.appbantraicay.ui.user.viewmodel.CartViewModel
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/27/2022
*/

@AndroidEntryPoint
public class FragmentCart : BaseFragment<FragmentCartBinding, CartViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_cart
    override val viewModel: CartViewModel by viewModels()

    @Inject
    lateinit var cartAdapter : RecyclerAdapterCart

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerCart.adapter = cartAdapter
        viewModel.listCart.observe(viewLifecycleOwner){
            cartAdapter.updateItems(it.toMutableList())
        }
    }
}
