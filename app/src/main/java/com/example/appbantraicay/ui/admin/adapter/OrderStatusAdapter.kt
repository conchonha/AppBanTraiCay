package com.example.appbantraicay.ui.admin.adapter

import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.Order
import com.example.appbantraicay.databinding.ItemOrderStatusBinding
import com.sangtb.androidlibrary.base.BaseRecyclerViewAdapter

class OrderStatusAdapter : BaseRecyclerViewAdapter<Order, ItemOrderStatusBinding>() {
    override fun onBindViewHolder(holder: BaseViewHolder<ItemOrderStatusBinding>, position: Int) {
        holder.binding.order = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(
                holder.itemView,
                items[position],
                position
            )
        }
    }

    override val layoutId: Int
        get() = R.layout.item_order_status
}