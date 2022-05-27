package com.example.appbantraicay.ui.user.viewmodel;

import android.app.Application
import com.sangtb.androidlibrary.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/27/2022
*/
@HiltViewModel
public class CartViewModel @Inject constructor(application: Application) : BaseViewModel(application) {
}
