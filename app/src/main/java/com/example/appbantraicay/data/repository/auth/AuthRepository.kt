package com.example.appbantraicay.data.repository.auth;

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.body.LoginBody
import com.example.appbantraicay.data.model.body.NewPassBody
import com.example.appbantraicay.data.model.body.RegisterBody
import com.example.appbantraicay.data.model.body.UpdateMyProfile
import com.example.appbantraicay.data.model.responses.ProductNew
import com.example.appbantraicay.data.model.responses.User
import com.example.appbantraicay.data.services.ApiServices
import com.example.appbantraicay.data.services.JavaMailAPI
import com.example.appbantraicay.utils.Const
import com.sangtb.androidlibrary.base.data.repository.BaseRepository
import javax.inject.Inject
import javax.inject.Singleton

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/26/2022
*/

@Singleton
class AuthRepository @Inject constructor(private val apiServices: ApiServices) : BaseRepository(),
    DefaultLifecycleObserver {
    private val _listProductSearch = MutableLiveData<List<ProductNew>>()
    val listProductSearch: LiveData<List<ProductNew>> = _listProductSearch

    fun login(loginBody: LoginBody, onSuccess: (List<User>) -> Unit) {
        callApi {
            onSuccess.invoke(apiServices.postLogin(loginBody))
        }
    }

    fun checkEmail(email: String, content: String, code: String, onSuccess: (Int?) -> Unit) {
        callApi {
            val value = apiServices.checkEmail(email)
            if (value == Const.SUCCESS) {
                JavaMailAPI.sendMail(email, content, code)
                onSuccess.invoke(null)
                return@callApi
            }
            onSuccess.invoke(R.string.email_do_not_exits)
        }
    }

    fun updatePasswordForEmail(newPassBody: NewPassBody, onSuccess: (String) -> Unit) {
        callApi {
            onSuccess.invoke(apiServices.updatePasswordForEmail(newPassBody))
        }
    }

    fun register(registerBody: RegisterBody, onSuccess: (String) -> Unit) {
        callApi {
            onSuccess.invoke(apiServices.register(registerBody))
        }
    }

    fun updateMyProFile(updateMyProfile: UpdateMyProfile,onSuccess: (List<User>) -> Unit){
        callApi {  onSuccess.invoke(apiServices.updateMyProfile(updateMyProfile)) }
    }

    suspend fun search(str: String) {
        try {
            _listProductSearch.postValue(apiServices.searchProduct(str))
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d(TAG, "search: ${e.message}")
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        cancelCoroutine()
        super.onDestroy(owner)
    }
}
