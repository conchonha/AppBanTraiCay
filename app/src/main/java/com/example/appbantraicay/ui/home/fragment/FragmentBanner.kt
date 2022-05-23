package com.example.appbantraicay.ui.home.fragment;

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.BannerFragmentBinding
import com.example.appbantraicay.ui.home.adapter.BannerAdapter
import com.example.appbantraicay.ui.home.viewmodel.HomeViewModel
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/

@AndroidEntryPoint
class FragmentBanner : BaseFragment<BannerFragmentBinding, HomeViewModel>() {
    private lateinit var runnable: Runnable
    override val layoutId: Int
        get() = R.layout.banner_fragment
    override val viewModel: HomeViewModel by activityViewModels()

    @Inject
    lateinit var adapter: BannerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewpagerBanner.adapter = adapter
            viewModel.listAdvertisement.observe(viewLifecycleOwner) {
                adapter.updateItems(it.toMutableList())
                pageIndicatorViewBanner.count = adapter.itemCount
                if(findNavController().currentDestination?.id == R.id.fragmentHome){
                    autoSlideViewpager()
                }
            }

            viewpagerBanner.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    pageIndicatorViewBanner.selection = position
                }
            })
        }
    }

    private fun autoSlideViewpager() {
       binding.apply {
           if (viewpagerBanner.adapter?.itemCount == null || viewpagerBanner.adapter?.itemCount == 0) return

           var currentItem = 0
           val handler = Handler(Looper.getMainLooper())
           runnable = Runnable {
               currentItem = viewpagerBanner.currentItem
               currentItem++
               if (currentItem >= viewpagerBanner.adapter?.itemCount ?: 0) {
                   currentItem = 0
               }
               viewpagerBanner.setCurrentItem(currentItem, true)
               handler.postDelayed(runnable, 3000)
           }
           handler.postDelayed(runnable, 3000)
       }
    }
}
