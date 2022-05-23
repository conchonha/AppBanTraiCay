package com.example.appbantraicay.ui.home.adapter;

import android.util.Log
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.Category
import com.example.appbantraicay.data.model.ProductNew
import com.example.appbantraicay.databinding.ItemProductHomeBinding
import com.example.appbantraicay.databinding.ItemTitleHomeBinding
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

    var actionItemCart : IActionItemAdapter? = null

    override fun onBindViewHolder(holder: BaseViewHolder<ItemTitleHomeBinding>, position: Int) {
        items[position].second?.let {
            holder.binding.title =
                if (position == 0) holder.itemView.context.getString(R.string.new_product) else items[position].first?.ten
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
