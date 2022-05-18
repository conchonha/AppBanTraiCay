package com.example.appbantraicay.ui.dialog;

import com.example.appbantraicay.R
import com.example.appbantraicay.common.SingleTonHolder
import com.example.appbantraicay.databinding.DialogLoadingBinding
import com.sangtb.androidlibrary.utils.DialogLibrary
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Singleton

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
@AndroidEntryPoint
class LoadingDialog : DialogLibrary<DialogLoadingBinding,Any>() {
    override val layout: Int
        get() = R.layout.dialog_loading

    companion object : SingleTonHolder<LoadingDialog>(::LoadingDialog)
}
