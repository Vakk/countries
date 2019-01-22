package com.valery.myapplication.ui.base.mvvm.viewmodel

import io.reactivex.disposables.CompositeDisposable

abstract class BaseRxViewModel : BaseViewModel() {

    protected val disposableBag = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposableBag.clear()
    }
}