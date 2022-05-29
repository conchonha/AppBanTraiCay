package com.example.appbantraicay.ui.admin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.data.model.responses.User
import com.example.appbantraicay.databinding.FragmentAccountBinding
import com.example.appbantraicay.ui.admin.adapter.AccountAdapter
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : BaseFragment<FragmentAccountBinding, AccountViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_account

    override val viewModel: AccountViewModel by viewModels()

    private val accountAdapter = AccountAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            adapter = accountAdapter
        }
        viewModel.listDataUser.observe(viewLifecycleOwner) {
            accountAdapter.updateItems(it as MutableList<User>)
        }
    }
}