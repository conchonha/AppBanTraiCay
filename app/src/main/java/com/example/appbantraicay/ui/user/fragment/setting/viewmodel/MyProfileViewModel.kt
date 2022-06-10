package com.example.appbantraicay.ui.user.fragment.setting.viewmodel

import android.app.Application
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.body.UpdateMyProfile
import com.example.appbantraicay.data.repository.auth.AuthRepository
import com.example.appbantraicay.utils.Const
import com.example.appbantraicay.utils.SharePrefs
import com.example.appbantraicay.utils.toJson
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
    private val sharePrefs: SharePrefs,
    private val authRepository: AuthRepository
) : BaseViewModel(application) {
    var user = sharePrefs.getUserInfo()
    val email = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val image = MutableLiveData<String>()
    val address = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    val hintPhone: LiveData<Int> = MutableLiveData(R.string.lbl_hint_phone)
    val hintAddress: LiveData<Int> = MutableLiveData(R.string.lbl_hint_address)
    val hintEmail: LiveData<Int> = MutableLiveData(R.string.lbl_hint_email)

    init {
        updateData()
    }

    fun onClickItem(itemId: Int) {
        when (itemId) {
            R.string.lbl_my_profile -> navigateToDestination(R.id.action_fragmentMyAccount_to_fragmentMyProfile)
            R.string.lbl_change_password -> navigateToDestination(
                R.id.action_fragmentMyAccount_to_fragmentNewPassword, bundleOf(
                    Const.KEY_EMAIL to user?.email
                )
            )
            R.string.lbl_help_support -> navigateToDestination(R.id.action_fragmentMyAccount_to_fragmentLocation)
            R.string.lbl_about -> navigateToDestination(R.id.action_fragmentMyAccount_to_fragmentAbout)
            R.string.lbl_setting -> navigateToDestination(R.id.action_fragmentMyAccount_to_fragmentSetting)
            R.string.lbl_logout -> {
                sharePrefs.removeUser()
                backScreen()
            }
        }
    }

    fun onClickUpdate() {
        authRepository.updateMyProFile(UpdateMyProfile(name.value,phone.value,email.value,user?.id.toString())){
            sharePrefs.saveUser(it[INDEX_0].toJson())
            updateData()
            showToast(R.string.update_success)
        }
    }

    fun onSaveButton() {
        showToast(R.string.save_font_size_success)
        backScreen()
    }

    private fun updateData(){
        user = sharePrefs.getUserInfo()
        email.postValue(user?.email.toString())
        phone.postValue(user?.phoneNumBer.toString())
        image.postValue(user?.image.toString())
        address.postValue(user?.address.toString())
        name.postValue(user?.userName.toString())
    }

    companion object{
        private const val INDEX_0 = 0
    }
}