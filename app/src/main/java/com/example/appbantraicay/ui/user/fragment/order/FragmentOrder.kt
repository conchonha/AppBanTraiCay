package com.example.appbantraicay.ui.user.fragment.order

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentOrderBinding
import com.example.appbantraicay.databinding.FragmentOrderUserBinding
import com.example.appbantraicay.ui.user.adapter.AdapterOrder
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.androidlibrary.utils.showPopUp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*
* Copyright © 2022 UITS CO.,LTD
* Created by SangTB on 09/06/2022.
*/

@AndroidEntryPoint
public class FragmentOrder : BaseFragment<FragmentOrderUserBinding,OrderViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_order_user
    override val viewModel: OrderViewModel by viewModels()

    @Inject
    lateinit var adapterOrder : AdapterOrder

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapterOrder
        binding.imgOption.showPopUp(R.menu.menu_status){
            viewModel.onClickMenuOption(it)
        }

        viewModel.listDataOrder.observe(viewLifecycleOwner){
            adapterOrder.updateItems(it.toMutableList())
        }
    }
}