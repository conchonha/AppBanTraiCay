package com.example.appbantraicay.ui.user.adapter;

import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.Category
import com.example.appbantraicay.data.model.responses.ProductNew
import com.example.appbantraicay.databinding.ItemProductHomeBinding
import com.example.appbantraicay.databinding.ItemTitleHomeBinding
import com.example.appbantraicay.ui.user.interfaces.IActionItemAdapterHome
import com.sangtb.androidlibrary.base.BaseRecyclerViewAdapter
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/

class AdapterRecyclerHome @Inject constructor() :
    BaseRecyclerViewAdapter<Pair<Category?, List<ProductNew>?>, ItemTitleHomeBinding>() {
    override val layoutId: Int
        get() = R.layout.item_title_home

    var actionItemCart : IActionItemAdapterHome? = null

    override fun onBindViewHolder(holder: BaseViewHolder<ItemTitleHomeBinding>, position: Int) {
        items[position].second?.let {
            holder.binding.title =
                if (position == 0) holder.itemView.context.getString(R.string.new_product) else items[position].first?.name
                    ?: ""
            val adapter = AdapterChild()
            adapter.updateItems(it.toMutableList())
            holder.binding.recyclerChild.adapter = adapter
        }
    }

    inner class AdapterChild : BaseRecyclerViewAdapter<ProductNew, ItemProductHomeBinding>() {
        override val layoutId: Int
            get() = R.layout.item_product_home

        override fun onBindViewHolder(
            holder: BaseViewHolder<ItemProductHomeBinding>,
            position: Int
        ) {
            holder.binding.product = items[position]
            actionItemCart?.let { holder.binding.action = it }
        }
    }
}
