package com.example.appbantraicay.ui;

import android.app.Application
import android.util.Log
import com.example.appbantraicay.common.interfaces.IActionMenuHeader
import com.example.appbantraicay.data.repository.Repository
import com.sangtb.androidlibrary.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/

@HiltViewModel
public class HomeViewModel @Inject constructor(
    application: Application,
    repository: Repository
) : BaseViewModel(application), IActionMenuHeader {

    override fun onClickItemTitle(itemTitleId: Int) {
        Log.d("AAAA", "onClickItemTitle: ")
    }

}
