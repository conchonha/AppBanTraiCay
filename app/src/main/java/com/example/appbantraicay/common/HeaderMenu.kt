package com.example.appbantraicay.common;

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.example.appbantraicay.common.interfaces.IActionMenuHeader
import com.example.appbantraicay.databinding.LayoutHeaderMenuBinding

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
@BindingMethods(
    BindingMethod(type = HeaderMenu::class,attribute = "app:setMenuListener",method = "setMenuListener")
)
class HeaderMenu(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private var listener : IActionMenuHeader? = null
    private var binding =
        LayoutHeaderMenuBinding.inflate(LayoutInflater.from(context),this,true)

    fun setMenuListener(action : IActionMenuHeader){
        listener = action
    }

    init {
        binding.apply {
            txtMenu.setOnClickListener {
                this.constraintGroup.visibility = VISIBLE
            }

            groupBtnAction.referencedIds.forEach { id->
                (findViewById(id) as? TextView)?.let {
                    it.setOnClickListener {
                        listener?.onClickItemTitle(id)
                        this.constraintGroup.visibility = GONE
                    }
                }
            }
        }
    }
}
