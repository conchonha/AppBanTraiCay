package com.example.appbantraicay.ui.user.fragment.order

import android.app.Application
import com.example.appbantraicay.R
import com.example.appbantraicay.data.repository.Repository
import com.sangtb.androidlibrary.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
* Copyright © 2022 UITS CO.,LTD
* Created by SangTB on 11/06/2022.
*/

@HiltViewModel
class OrderViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
) : BaseViewModel(application){

    init {
        repository.getDataWaitingForApproval()
    }

    val listDataOrder = repository.listOderWaitingApproval

    fun onClickMenuOption(itemId : Int){
        when(itemId){
            R.id.menu_pending_approve -> repository.getDataWaitingForApproval()
            R.id.being_transported -> repository.getDataBeingAndTransported()
            R.id.delivered -> repository.getDataDelivered()
            R.id.canceled -> repository.getDataCanceled()
        }
    }
}