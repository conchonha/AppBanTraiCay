package com.example.appbantraicay.ui.admin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.Order
import com.example.appbantraicay.databinding.FragmentOrderStatusBinding
import com.example.appbantraicay.ui.admin.adapter.OrderStatusAdapter
import com.example.appbantraicay.utils.TitleId
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderStatusFragment(private val title: Int) :
    BaseFragment<FragmentOrderStatusBinding, OrderStatusViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_order_status
    override val viewModel: OrderStatusViewModel by viewModels()

    private val orderDeletedAdapter = OrderStatusAdapter()

    private val orderTransportingAdapter = OrderStatusAdapter()

    private val orderSuccessAdapter = OrderStatusAdapter()

    private val orderApprovingAdapter = OrderStatusAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            adapter = when (title) {
                TitleId.TITLE_ORDER_APPROVING -> orderApprovingAdapter
                TitleId.TITLE_ORDER_DELETED -> orderDeletedAdapter
                TitleId.TITLE_ORDER_SUCCESS -> orderSuccessAdapter
                TitleId.TITLE_ORDER_TRANSPORTING -> orderTransportingAdapter
                else -> orderSuccessAdapter
            }

            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
        }

        viewModel.apply {
            listDataOrderApproving.observe(viewLifecycleOwner) {
                orderApprovingAdapter.updateItems(it as MutableList<Order>)
            }

            listDataOrderDeleted.observe(viewLifecycleOwner) {
                orderDeletedAdapter.updateItems(it as MutableList<Order>)
            }

            listDataOrderSuccess.observe(viewLifecycleOwner) {
                orderSuccessAdapter.updateItems(it as MutableList<Order>)
            }

            listDataOrderTransportting.observe(viewLifecycleOwner) {
                orderTransportingAdapter.updateItems(it as MutableList<Order>)
            }
        }
    }
}