package com.example.appbantraicay.ui.admin

import android.app.Application
import com.example.appbantraicay.data.repository.Repository
import com.sangtb.androidlibrary.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(application: Application, private val repository : Repository) : BaseViewModel(application) {

    val listDataProduct = repository.listDataProduct
}