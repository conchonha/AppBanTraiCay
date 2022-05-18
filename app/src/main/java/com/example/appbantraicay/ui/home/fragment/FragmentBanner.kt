package com.example.appbantraicay.ui.home.fragment;

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.BannerFragmentBinding
import com.example.appbantraicay.ui.home.HomeViewModel
import com.example.appbantraicay.ui.home.adapter.BannerAdapter
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/

@AndroidEntryPoint
class FragmentBanner : BaseFragment<BannerFragmentBinding, HomeViewModel>() {
    override val layoutId: Int
        get() = R.layout.banner_fragment
    override val viewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var adapter : BannerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewpagerBanner.adapter = adapter
            viewModel.listAdvertisement.observe(viewLifecycleOwner){
                adapter.updateItems(it.toMutableList())
                pageIndicatorViewBanner.count = adapter.itemCount
            }

            viewpagerBanner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    pageIndicatorViewBanner.selection = position
                }
            })
        }

    }
}
