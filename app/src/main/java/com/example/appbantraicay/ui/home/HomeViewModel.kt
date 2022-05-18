package com.example.appbantraicay.ui.home;

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.appbantraicay.common.interfaces.IActionMenuHeader
import com.example.appbantraicay.data.model.Advertisement
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
    private val repository: Repository
) : BaseViewModel(application), IActionMenuHeader {

    val listAdvertisement: LiveData<List<Advertisement>>
        get() = repository.listAdvertisement

    override fun onClickItemTitle(itemTitleId: Int) {
        Log.d("AAAA", "onClickItemTitle: ")
    }

}
