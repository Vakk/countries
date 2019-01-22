package com.valery.myapplication.ui.base.mvvm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.valery.myapplication.ui.base.fragment.BaseFragment

abstract class BaseMvvmFragment<VM : ViewModel>(private val viewModelClass: Class<VM>) : BaseFragment() {

    var onFirstViewModelInit: ((VM) -> Unit)? =
        null // can be used for inject some objects (f.e: we want to open some info screen with loaded model).

    protected lateinit var viewModel: VM // you can access view model of this fragment by this property. This property will be initialized during view lifecycle.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareViewModel()
        onPrepareObservers()
    }

    private fun prepareViewModel() {
        viewModel = ViewModelProviders.of(this).get(viewModelClass)
        onFirstViewModelInit?.invoke(viewModel)
        onFirstViewModelInit = null // remove this callback. View model is already initialized.
    }

    /**
     * Notifies when view view model is ready and you can bind to values.
     */
    protected open fun onPrepareObservers() {

    }

    protected fun <F> LiveData<F>.observe(observer: Observer<F>) { // just for simplify using of default owner.
        observe(this@BaseMvvmFragment, observer)
    }

}