package com.valery.myapplication.ui.base.mvvm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import com.valery.myapplication.ui.base.fragment.BaseFragment
import com.valery.myapplication.ui.base.mvvm.viewmodel.BaseViewModel
import com.valery.myapplication.ui.main.MessageController
import com.valery.myapplication.ui.main.ProgressController

abstract class BaseMvvmFragment<VM : BaseViewModel>(private val viewModelClass: Class<VM>) : BaseFragment() {

    var onFirstViewModelInit: (VM.() -> Unit)? =
            null // can be used for inject some objects (f.e: we want to open some info screen with loaded model).

    protected lateinit var viewModel: VM // you can access view model of this fragment by this property. This property will be initialized during view lifecycle.

    private var progressController: ProgressController? = null
    private var messageController: MessageController? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        progressController = bindInterfaceOrThrow(context)
        messageController = bindInterfaceOrThrow(context)
    }

    override fun onDetach() {
        super.onDetach()
        progressController = null
        messageController = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareViewModel()
        onPrepareObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.onMessageLiveData.removeObservers(this)
        viewModel.onLoadingLiveData.removeObservers(this)
    }

    private fun prepareViewModel() {
        viewModel = ViewModelProviders.of(this).get(viewModelClass)
        onFirstViewModelInit?.invoke(viewModel).apply { }
        onFirstViewModelInit = null // remove this callback. View model is already initialized.
    }

    /**
     * Notifies when view view model is ready and you can bind to values.
     */
    protected open fun onPrepareObservers() {
        viewModel.onLoadingLiveData.observe(Observer {
            it?.let {
                showProgress(it)
            }
        })

        viewModel.onMessageLiveData.observe(Observer {
            it?.let {
                messageController?.showMessage(it)
            }
        })
    }

    protected fun <F> LiveData<F>.observe(observer: Observer<F>) { // just for simplify using of default owner.
        observe(this@BaseMvvmFragment, observer)
    }

    protected open fun showProgress(isVisible: Boolean) {
        progressController?.changeProgressViewStatus(isVisible)
    }

    protected open fun showMessage(message: String) {
        messageController?.showMessage(message)
    }
}