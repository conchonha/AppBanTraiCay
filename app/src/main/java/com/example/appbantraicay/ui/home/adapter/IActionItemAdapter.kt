package com.example.appbantraicay.ui.home.adapter;

import com.example.appbantraicay.data.model.ProductNew

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/19/2022
*/
interface IActionItemAdapter {
    fun onClickBuyCart(productNew: ProductNew)
    fun onClickDetail(productNew: ProductNew)
}
