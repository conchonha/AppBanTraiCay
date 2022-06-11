package com.example.appbantraicay.ui.user.fragment.home.viewmodel;

import android.app.Application
import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.appbantraicay.R
import com.example.appbantraicay.common.interfaces.IActionMenuHeader
import com.example.appbantraicay.data.model.responses.User
import com.example.appbantraicay.data.repository.Repository
import com.example.appbantraicay.data.repository.auth.AuthRepository
import com.example.appbantraicay.utils.SharePrefs
import com.sangtb.androidlibrary.base.BaseViewModel
import com.sangtb.androidlibrary.utils.getStatusBarHeight
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/29/2022
*/

@HiltViewModel
public class HeaderViewModel @Inject constructor(
    application: Application,
    private val sharePrefs: SharePrefs,
    private val authRepository: AuthRepository,
    private val repository: Repository
) : BaseViewModel(application), IActionMenuHeader {
    val heightStatusBar: LiveData<Int> = MutableLiveData(application.getStatusBarHeight())
    val listSearchProduct = authRepository.listProductSearch
    val edittextSearch = MutableLiveData<String>()
    val listCart = repository.listCart

    private val _userInfo = MutableLiveData<Pair<String, String>>()
    val userInfo: LiveData<Pair<String, String>> = _userInfo

    private fun signOut() {
        if (userInfo.value?.first != EMPTY) {
            sharePrefs.removeUser()
        }
    }

    fun doAfterSearchChange(editable: Editable?) {
        viewModelScope.launch {
            authRepository.search(editable.toString())
        }
    }

    //load user info header
    fun loadUserInfo() {
        _userInfo.postValue(checkUser(sharePrefs.getUserInfo()))
    }

    private fun checkUser(userInfo: User?): Pair<String, String> {
        return userInfo?.userName?.let { Pair(it, getString(R.string.sing_out)) } ?: Pair(
            "", getString(
                R.string.sign_in
            )
        )
    }

    companion object {
        private const val EMPTY = ""
    }

    fun onClickSignOut() {
        navigateToDestination(R.id.login)
        signOut()
    }

    override fun onClickItemTitle(itemTitleId: Int) {
        when (itemTitleId) {
            R.id.txt_home -> navigateToDestination(R.id.action_global_fragmentHome)
            R.id.txt_cart -> checkNavigate(R.id.fragmentCart)
            R.id.txt_news -> navigateToDestination(R.id.reportFragment)
            R.id.txt_profile -> checkNavigate(R.id.fragmentMyAccount)
            R.id.txt_order -> checkNavigate(R.id.fragmentOrder)
            R.id.txt_help_support -> navigateToDestination(R.id.fragmentLocation)
        }
    }

    private fun checkNavigate(actionId: Int) {
        if (sharePrefs.getUserInfo() != null) {
            navigateToDestination(actionId)
            return
        }
        showToast(R.string.please_sign_in)
    }
}
