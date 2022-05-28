package com.example.appbantraicay.ui.auth.viewmodel

import android.app.Application
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.body.LoginBody
import com.example.appbantraicay.data.repository.auth.AuthRepository
import com.example.appbantraicay.ui.dialog.DialogVerifyAccount
import com.example.appbantraicay.utils.Const
import com.example.appbantraicay.utils.Const.KEY_EMAIL
import com.example.appbantraicay.utils.SharePrefs
import com.example.appbantraicay.utils.toJson
import com.sangtb.androidlibrary.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val repository: AuthRepository,
    private val sharePrefs: SharePrefs
) :
    BaseViewModel(application) {
    private val dialog by lazy { DialogVerifyAccount() }
    private var textCode = Random.nextInt(RANDOM_CODE_VERIFY_EMAIL).toString()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val editTextCode = MutableLiveData<String>()

    fun loginUser() {
        repository.login(LoginBody(email.value, password.value)) {
            if (it.isNotEmpty()) {
                sharePrefs.saveUser(it[INDEX_ZERO].toJson())
                backScreen()
                return@login
            }
            showToast(R.string.login_faild)
        }
    }

    fun showDialogVerifyEmail(fragmentManager: FragmentManager) {
        repository.checkEmail(
            email.value!!,
            getString(R.string.lbl_error_verify_code),
            Random.nextInt(RANDOM_CODE_VERIFY_EMAIL).toString().also {
                textCode = it
            }) {
            it?.let { showToast(it) } ?: dialog.show(fragmentManager)
        }
    }

    fun navigateRegister(){
        navigateToDestination(R.id.action_login_to_fragmentRegister)
    }

    //click button send from dialog screen
    fun sendCodeVerifyEmail() {
        if (editTextCode.value == textCode) {
            dialog.dismiss()
            navigateToDestination(
                R.id.action_login_to_fragmentNewPassword,
                bundleOf(KEY_EMAIL to email.value)
            )
            return
        }
        showToast(R.string.verify_code_incorrect)
    }

    override fun onCleared() {
        dialog.onDetach()
        super.onCleared()
    }

    companion object {
        private const val INDEX_ZERO = 0
        private const val RANDOM_CODE_VERIFY_EMAIL = 1000000
    }
}