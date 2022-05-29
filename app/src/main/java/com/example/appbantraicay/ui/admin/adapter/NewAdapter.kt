package com.example.appbantraicay.ui.admin.adapter

import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.New
import com.example.appbantraicay.databinding.ItemNewsBinding
import com.sangtb.androidlibrary.base.BaseRecyclerViewAdapter

class NewAdapter : BaseRecyclerViewAdapter<New, ItemNewsBinding>() {
    override fun onBindViewHolder(holder: BaseViewHolder<ItemNewsBinding>, position: Int) {
        holder.binding.news = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(
                holder.itemView,
                items[position],
                position
            )
        }
    }

    override val layoutId: Int
        get() = R.layout.item_news
}