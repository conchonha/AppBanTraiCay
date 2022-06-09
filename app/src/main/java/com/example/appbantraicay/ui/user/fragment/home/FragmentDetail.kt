package com.example.appbantraicay.ui.user.fragment.home;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentDetailBinding
import com.example.appbantraicay.ui.user.fragment.home.viewmodel.HomeViewModel
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/19/2022
*/

@AndroidEntryPoint
class FragmentDetail : BaseFragment<FragmentDetailBinding, HomeViewModel>(){
    override val layoutId: Int
        get() = R.layout.fragment_detail
    override val viewModel: HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun onDestroy() {
        viewModel.removeBannerDetail()
        super.onDestroy()
    }
}
