package com.example.appbantraicay.ui.admin

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.appbantraicay.R
import com.example.appbantraicay.utils.TitleId
import com.sangtb.androidlibrary.base.AppEvent
import com.sangtb.androidlibrary.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AdminViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    fun onNavigate(itemTitle: Int) {
        viewModelScope.launch {
            when (itemTitle) {
                TitleId.TITLE_ACCOUNT -> evenSender.send(AppEvent.OnNavigation(R.id.action_adminFragment_to_accountFragment))
                TitleId.TITLE_ORDER -> evenSender.send(AppEvent.OnNavigation(R.id.action_adminFragment_to_orderFragment))
                TitleId.TITLE_PRODUCT -> evenSender.send(AppEvent.OnNavigation(R.id.action_adminFragment_to_productFragment))
                TitleId.TITLE_REPORTS -> evenSender.send(AppEvent.OnNavigation(R.id.action_adminFragment_to_reportFragment))
                else -> {
                    Log.d(TAG, "onNavigate: not found action id")
                }
            }
        }
    }
}