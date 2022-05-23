package com.example.appbantraicay.ui.auth

import android.app.Application
import com.sangtb.androidlibrary.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(application: Application) : BaseViewModel(application) {
}