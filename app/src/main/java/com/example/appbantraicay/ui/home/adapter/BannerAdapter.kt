package com.example.appbantraicay.ui.home.adapter

import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.Advertisement
import com.example.appbantraicay.databinding.ItemBannerHomeBinding
import com.sangtb.androidlibrary.base.BaseRecyclerViewAdapter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BannerAdapter @Inject constructor() :
    BaseRecyclerViewAdapter<Pair<Int?,String?>, ItemBannerHomeBinding>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override val layoutId: Int
        get() = R.layout.item_banner_home

    override fun onBindViewHolder(holder: BaseViewHolder<ItemBannerHomeBinding>, position: Int) {
        holder.binding.url = items[position].second
        holder.binding.root.setOnClickListener {
            listener?.invoke(holder.itemView, items[position], position)
        }
    }
}