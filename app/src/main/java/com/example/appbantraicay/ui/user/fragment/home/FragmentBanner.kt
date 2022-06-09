package com.example.appbantraicay.ui.user.fragment.home;

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
import com.example.appbantraicay.ui.user.adapter.BannerAdapter
import com.example.appbantraicay.ui.user.fragment.home.viewmodel.HomeViewModel
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
                Log.d("SangTB", "onViewCreated listAdvertisement: ")
                it?.let {
                    adapter.updateItems(it.toMutableList())
                    pageIndicatorViewBanner.count = adapter.itemCount
                    if(findNavController().currentDestination?.id == R.id.fragmentHome){
                        autoSlideViewpager()
                    }
                }
            }

            viewpagerBanner.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    pageIndicatorViewBanner.selection = position
                }
            })

            adapter.listener = {_,item,_->
                viewModel.bannerHomeClick(item.first)
            }
        }
    }

    private fun autoSlideViewpager() {
       binding.apply {
           if (viewpagerBanner.adapter?.itemCount == null || viewpagerBanner.adapter?.itemCount == DEFAULT_VALUE) return

           var currentItem = DEFAULT_VALUE
           val handler = Handler(Looper.getMainLooper())
           runnable = Runnable {
               currentItem = viewpagerBanner.currentItem
               currentItem++
               if (currentItem >= viewpagerBanner.adapter?.itemCount ?: DEFAULT_VALUE) {
                   currentItem = DEFAULT_VALUE
               }
               viewpagerBanner.setCurrentItem(currentItem, true)
               handler.postDelayed(runnable, DURATION_TIME)
           }
           handler.postDelayed(runnable, DURATION_TIME)
       }
    }

    companion object{
        private const val DEFAULT_VALUE = 0
        private const val DURATION_TIME = 4000L
    }
}
