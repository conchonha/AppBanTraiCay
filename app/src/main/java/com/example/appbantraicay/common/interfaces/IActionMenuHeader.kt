package com.example.appbantraicay.common.interfaces;

import com.example.appbantraicay.ui.home.adapter.IActionItemAdapter

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
interface IActionMenuHeader {
    fun onClickItemTitle(itemTitleId : Int)
    val actionItemAdapter : IActionItemAdapter
}
