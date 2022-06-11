package com.example.appbantraicay.ui.user.fragment.cart;

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentCartBinding
import com.example.appbantraicay.ui.dialog.DialogOptionPay
import com.example.appbantraicay.ui.dialog.DialogWhenMultiplying
import com.example.appbantraicay.ui.user.adapter.RecyclerAdapterCart
import com.example.appbantraicay.ui.user.fragment.cart.viewmodel.CartViewModel
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/27/2022
*/

@AndroidEntryPoint
public class FragmentCart : BaseFragment<FragmentCartBinding, CartViewModel>() {
    private val dialog by lazy { DialogOptionPay() }
    private val dialogWhenMultiplying by lazy { DialogWhenMultiplying() }

    override val layoutId: Int
        get() = R.layout.fragment_cart
    override val viewModel: CartViewModel by activityViewModels()

    @Inject
    lateinit var cartAdapter : RecyclerAdapterCart

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolBar()

        cartAdapter.action = viewModel
        binding.recyclerCart.adapter = cartAdapter
        viewModel.listCart.observe(viewLifecycleOwner){
            cartAdapter.updateItems(it.toMutableList())
        }

        viewModel.showDialogSing.observe(viewLifecycleOwner){
            if(dialog.isAdded) dialog.dismiss()
            if(it){
                dialog.show(childFragmentManager,TAG)
            }
        }

        viewModel.showDialogWhenMultiplying.observe(viewLifecycleOwner){
            if(dialogWhenMultiplying.isAdded) dialogWhenMultiplying.dismiss()
            if(it){
                dialogWhenMultiplying.show(childFragmentManager,TAG1)
            }
        }
    }

    private fun initToolBar() {
        binding.action = viewModel

        activity.apply {
            (this as? AppCompatActivity)?.let {
                setSupportActionBar(binding.toolbarCart)
                supportActionBar?.setDisplayHomeAsUpEnabled(true)

                binding.toolbarCart.apply {
                    setNavigationIcon(R.drawable.ic_back)
                    setNavigationOnClickListener {
                        viewModel.backScreen()
                    }
                }
            }
        }
    }

    companion object{
        private const val TAG1 = "Fragment_Cart"
    }
}
