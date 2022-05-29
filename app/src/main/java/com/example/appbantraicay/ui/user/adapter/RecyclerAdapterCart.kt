package com.example.appbantraicay.ui.user.adapter;

import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.Cart
import com.example.appbantraicay.databinding.ItemCartBinding
import com.sangtb.androidlibrary.base.BaseRecyclerViewAdapter
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/29/2022
*/

public class RecyclerAdapterCart @Inject constructor() : BaseRecyclerViewAdapter<Cart,ItemCartBinding>() {
    override val layoutId: Int
        get() = R.layout.item_cart

    override fun onBindViewHolder(holder: BaseViewHolder<ItemCartBinding>, position: Int) {
        holder.binding.cart = items[position]
    }
}
