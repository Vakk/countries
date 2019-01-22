package com.valery.myapplication.ui.base.mvvm.viewmodel

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

abstract class BaseRxViewModel : BaseViewModel() {

    protected val disposableBag = CompositeDisposable()

    protected val onSuccess = Consumer<Any> {
        hideLoader()
    }

    protected val onSuccessEmpty = Consumer<Any> {

    }

    protected val onError = Consumer<Throwable> {
        it?.printStackTrace()
        showMessage(it.message ?: "Something went wrong.")
    }

    override fun onCleared() {
        super.onCleared()
        disposableBag.clear()
    }
}