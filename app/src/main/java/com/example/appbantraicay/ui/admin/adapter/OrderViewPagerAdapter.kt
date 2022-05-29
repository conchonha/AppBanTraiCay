package com.example.appbantraicay.ui.admin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.appbantraicay.ui.admin.OrderStatusFragment
import com.example.appbantraicay.utils.Const.NUM_PAGES
import com.example.appbantraicay.utils.TitleId

class OrderViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> OrderStatusFragment(TitleId.TITLE_ORDER_SUCCESS)
        1 -> OrderStatusFragment(TitleId.TITLE_ORDER_TRANSPORTING)
        2 -> OrderStatusFragment(TitleId.TITLE_ORDER_DELETED)
        3 -> OrderStatusFragment(TitleId.TITLE_ORDER_APPROVING)
        else -> OrderStatusFragment(TitleId.TITLE_ORDER_SUCCESS)
    }
}