package com.example.appbantraicay.ui.user.fragment.setting.viewmodel

import android.app.Application
import android.util.Log
import com.example.appbantraicay.R
import com.example.appbantraicay.utils.SharePrefs
import com.sangtb.androidlibrary.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
* Copyright © 2022 UITS CO.,LTD
* Created by SangTB on 08/06/2022.
*/

@HiltViewModel
class MyProfileViewModel @Inject constructor(
    application: Application,
    private val sharePrefs: SharePrefs
) : BaseViewModel(application) {
    fun onClickItem(itemId : Int){
        when(itemId){
            R.string.lbl_my_profile ->navigateToDestination(R.id.action_fragmentMyAccount_to_fragmentMyProfile)
            R.string.lbl_change_password -> {}
            R.string.lbl_help_support -> {}
            R.string.lbl_about -> navigateToDestination(R.id.action_fragmentMyAccount_to_fragmentAbout)
            R.string.lbl_setting ->navigateToDestination(R.id.action_fragmentMyAccount_to_fragmentSetting)
            R.string.lbl_logout-> {
                sharePrefs.removeUser()
                backScreen()
            }
        }
    }

    fun onSaveButton(){
        showToast(R.string.save_font_size_success)
        backScreen()
    }
}