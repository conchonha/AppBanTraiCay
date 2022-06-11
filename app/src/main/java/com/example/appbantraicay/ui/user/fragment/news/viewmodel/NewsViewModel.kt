package com.example.appbantraicay.ui.user.fragment.news.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.New
import com.example.appbantraicay.data.repository.Repository
import com.sangtb.androidlibrary.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(application: Application, private val repository : Repository) : BaseViewModel(application) {
    val listDataNews = repository.listDataNews

    private val _news = MutableLiveData<New>()
    val news : LiveData<New> = _news

    fun search(str : String) = viewModelScope.launch {
        repository.getDataSearchNews(str)
    }

    fun setDataNews(new : New){
        _news.value = new
        navigateToDestination(R.id.action_reportFragment_to_fragmentDetailNews)
    }
}