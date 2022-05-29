package com.example.appbantraicay.ui.user.viewmodel;

import android.app.Application
import android.text.Editable
import android.util.Log
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
import com.sangtb.androidlibrary.base.action.ItemMenuAction
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
) : BaseViewModel(application), IActionMenuHeader{
    val heightStatusBar: LiveData<Int> = MutableLiveData(application.getStatusBarHeight())
    val listSearchProduct = authRepository.listProductSearch
    val edittextSearch = MutableLiveData<String>()
    val listCart = repository.listCart

    private val _userInfo = MutableLiveData<Pair<String,String>>()
    val userInfo : LiveData<Pair<String,String>> = _userInfo

    fun signOut(){
        if(userInfo.value?.first != EMPTY){
            sharePrefs.removeUser()
        }
    }

    override fun onClickItemTitle(itemTitleId: Int) {
        Log.d(TAG, "onClickItemTitle Header Menu: ")
    }

    fun doAfterSearchChange(editable: Editable?){
        viewModelScope.launch {
            authRepository.search(editable.toString())
        }
    }

    //load user info header
    fun loadUserInfo() {
        _userInfo.postValue(checkUser(sharePrefs.getUserInfo()))
    }

    private fun checkUser(userInfo: User?): Pair<String, String>{
        return userInfo?.userName?.let { Pair(it,getString(R.string.sing_out))} ?: Pair("",getString(
            R.string.sign_in))
    }

    companion object{
        private const val EMPTY = ""
    }
}
