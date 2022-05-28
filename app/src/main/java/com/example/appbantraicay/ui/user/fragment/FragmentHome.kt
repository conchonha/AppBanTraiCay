package com.example.appbantraicay.ui.user.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.HomeFragmentBinding
import com.example.appbantraicay.ui.user.viewmodel.HomeViewModel
import com.example.appbantraicay.ui.user.adapter.AdapterRecyclerHome
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/

@AndroidEntryPoint
class FragmentHome : BaseFragment<HomeFragmentBinding, HomeViewModel>() {
    override val layoutId: Int
        get() = R.layout.home_fragment
    override val viewModel: HomeViewModel by activityViewModels()

    @Inject
    @Singleton
    lateinit var adapterMenu : AdapterRecyclerHome

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterMenu.actionItemCart = viewModel
        binding.viewModel = viewModel

        binding.recyclerBody.apply {
            adapter = adapterMenu
            isNestedScrollingEnabled = false
        }

        viewModel.listProductCategory.observe(viewLifecycleOwner){
            adapterMenu.updateItems(it.toMutableList())
        }
    }
}
