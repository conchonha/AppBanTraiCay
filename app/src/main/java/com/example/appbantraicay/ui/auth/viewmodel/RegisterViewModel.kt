package com.example.appbantraicay.ui.auth.viewmodel;

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.body.RegisterBody
import com.example.appbantraicay.data.repository.auth.AuthRepository
import com.example.appbantraicay.utils.Const
import com.sangtb.androidlibrary.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/28/2022
*/

@HiltViewModel
public class RegisterViewModel @Inject constructor(
    application: Application,
    private val authRepository: AuthRepository
) : BaseViewModel(application) {
    val userName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun register() {
        authRepository.register(
            RegisterBody(
                userName = userName.value,
                password = password.value,
                email = email.value
            )
        ) {
            if(it == Const.SUCCESS){
                Log.d(TAG, "register: ")
                showToast(R.string.register_success)
                backScreen()
            }
        }
    }
}
