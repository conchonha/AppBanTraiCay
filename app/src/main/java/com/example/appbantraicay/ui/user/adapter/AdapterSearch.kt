package com.example.appbantraicay.ui.user.adapter;

import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.ProductNew
import com.example.appbantraicay.databinding.ItemProductSearchBinding
import com.sangtb.androidlibrary.base.BaseRecyclerViewAdapter
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/29/2022
*/

public class AdapterSearch @Inject constructor() : BaseRecyclerViewAdapter<ProductNew,ItemProductSearchBinding>() {
    override val layoutId: Int
        get() = R.layout.item_product_search

    override fun onBindViewHolder(holder: BaseViewHolder<ItemProductSearchBinding>, position: Int) {
        holder.binding.apply {
            product = items[position]

            root.setOnClickListener { listener?.invoke(it,items[position],position) }
        }
    }
}
