package com.valery.myapplication.ui.countries

import com.valery.myapplication.R
import com.valery.myapplication.ui.base.mvvm.BaseMvvmFragment

class CountriesFragment : BaseMvvmFragment<CountriesViewModel>(CountriesViewModel::class.java) {

    override val layoutId: Int = R.layout.fragment_countries

}