package com.example.appbantraicay.ui.user.fragment.news

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.New
import com.example.appbantraicay.databinding.FragmentNewsBinding
import com.example.appbantraicay.ui.admin.adapter.NewAdapter
import com.example.appbantraicay.ui.user.fragment.news.viewmodel.NewsViewModel
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_news

    override val viewModel: NewsViewModel by activityViewModels()

    @Inject
    lateinit var newAdapter : NewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerView.adapter = newAdapter

            edtSearch.doAfterTextChanged {
                viewModel.search(it.toString())
            }
        }

        viewModel.listDataNews.observe(viewLifecycleOwner) {
            newAdapter.updateItems(it as MutableList<New>)
        }

        newAdapter.listener = {_,news,_->
            viewModel.setDataNews(news)
        }
    }
}