package com.valery.myapplication.ui.base.mvvm.viewmodel

import com.valery.myapplication.dagger.DaggerManager

abstract class BaseDaggerRxViewModel : BaseRxViewModel() {
    protected val daggerManager = DaggerManager
}