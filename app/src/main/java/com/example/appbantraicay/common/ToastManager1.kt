package com.example.appbantraicay.common;

import com.sangtb.androidlibrary.utils.SingleLiveEvent

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/24/2022
*/
class ToastManager1 private constructor(){

    val errorThrowable = SingleLiveEvent<Throwable>()

    val loadingDialog = SingleLiveEvent<Boolean>()

    private object Holder { val INSTANCE = ToastManager1()}

    companion object{
        @JvmStatic
        fun getInstance(): ToastManager1{
            return Holder.INSTANCE
        }
    }
}