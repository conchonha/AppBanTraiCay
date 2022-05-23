package com.example.appbantraicay.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.appbantraicay.R
import com.example.appbantraicay.common.ToastManager1
import com.example.appbantraicay.data.repository.IActionRepository
import com.example.appbantraicay.data.repository.Repository
import com.example.appbantraicay.ui.dialog.LoadingDialog
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _navHostController: NavController
    private lateinit var _navHostFragment: NavHostFragment
    private val dialog by lazy { LoadingDialog() }
    private val toastManager by lazy { ToastManager1.getInstance() }

    @Inject
    @Singleton
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(repository)

        toastManager.loadingDialog.observe(this) {
            if (dialog.isVisible) dialog.dismiss()
            if (it) dialog.show(supportFragmentManager, TAG)
        }

        toastManager.errorThrowable.observe(this){
            Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
        }

        _navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        _navHostController = _navHostFragment.navController
    }

    fun refreshCurrentFragment() {
        val id = _navHostController.currentDestination?.id
        _navHostController.popBackStack(id!!, true)
        _navHostController.navigate(id)
    }

    companion object {
        private val TAG = this.javaClass.name
    }
}