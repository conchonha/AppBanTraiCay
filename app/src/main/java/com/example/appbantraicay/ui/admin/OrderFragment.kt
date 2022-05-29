package com.example.appbantraicay.ui.admin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentOrderBinding
import com.example.appbantraicay.ui.admin.adapter.OrderViewPagerAdapter
import com.example.appbantraicay.utils.TitleId
import com.google.android.material.tabs.TabLayoutMediator
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderFragment : BaseFragment<FragmentOrderBinding, OrderViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_order
    override val viewModel: OrderViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val orderAdapter = OrderViewPagerAdapter(requireActivity())
        binding.apply {
            pager.adapter = orderAdapter
            TabLayoutMediator(tabLayout, pager) { tab, position ->
                val tabNames = listOf(
                    getString(TitleId.TITLE_ORDER_SUCCESS),
                    getString(TitleId.TITLE_ORDER_TRANSPORTING),
                    getString(TitleId.TITLE_ORDER_DELETED),
                    getString(TitleId.TITLE_ORDER_APPROVING)
                )
                tab.text = tabNames[position]
            }.attach()
        }

    }
}