package com.valery.myapplication.ui.countries

import com.valery.myapplication.ui.base.mvvm.viewmodel.BaseDaggerRxViewModel

class CountriesViewModel : BaseDaggerRxViewModel() {
    init {
        daggerManager.sessionComponent?.inject(this)
    }
}