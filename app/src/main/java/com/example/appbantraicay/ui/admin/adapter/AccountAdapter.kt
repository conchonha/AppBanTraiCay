package com.example.appbantraicay.ui.admin.adapter

import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.User
import com.example.appbantraicay.databinding.ItemAccountBinding
import com.sangtb.androidlibrary.base.BaseRecyclerViewAdapter
import javax.inject.Singleton

@Singleton
class AccountAdapter : BaseRecyclerViewAdapter<User, ItemAccountBinding>() {
    override fun onBindViewHolder(holder: BaseViewHolder<ItemAccountBinding>, position: Int) {
        holder.binding.user = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(
                holder.itemView,
                items[position],
                position
            )
        }
    }

    override val layoutId: Int
        get() = R.layout.item_account
}