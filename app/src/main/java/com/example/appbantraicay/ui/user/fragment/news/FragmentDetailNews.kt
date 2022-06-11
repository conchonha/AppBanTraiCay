package com.example.appbantraicay.ui.user.fragment.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentDetailNewsBinding
import com.example.appbantraicay.ui.user.fragment.news.viewmodel.NewsViewModel
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/*
* Copyright © 2022 UITS CO.,LTD
* Created by SangTB on 12/06/2022.
*/

@AndroidEntryPoint
class FragmentDetailNews : BaseFragment<FragmentDetailNewsBinding,NewsViewModel>(){
    override val layoutId: Int
        get() = R.layout.fragment_detail_news

    override val viewModel: NewsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.news.observe(viewLifecycleOwner){
            binding.news = it
        }
    }
}