package com.example.appbantraicay.ui.admin.adapter

import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.DataProduct
import com.example.appbantraicay.databinding.ItemProductBinding
import com.sangtb.androidlibrary.base.BaseRecyclerViewAdapter
import javax.inject.Singleton

@Singleton
class ProductAdapter : BaseRecyclerViewAdapter<DataProduct, ItemProductBinding>() {
    override fun onBindViewHolder(holder: BaseViewHolder<ItemProductBinding>, position: Int) {
        holder.binding.product = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(
                holder.itemView,
                items[position],
                position
            )
        }
    }

    override val layoutId: Int
        get() = R.layout.item_product
}