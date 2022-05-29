package com.example.appbantraicay.ui.admin

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.New
import com.example.appbantraicay.databinding.FragmentNewsBinding
import com.example.appbantraicay.ui.admin.adapter.NewAdapter
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_news

    override val viewModel: NewsViewModel by viewModels()

    private val newAdapter = NewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            adapter = newAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
        viewModel.listDataNews.observe(viewLifecycleOwner) {
            Log.d(TAG, "onViewCreated: listDataNews $it")
            newAdapter.updateItems(it as MutableList<New>)
        }
    }
}