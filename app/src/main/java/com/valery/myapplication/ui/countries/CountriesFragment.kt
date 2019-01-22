package com.valery.myapplication.ui.countries

import com.valery.myapplication.R
import com.valery.myapplication.ui.base.mvvm.BaseMvvmFragment

class CountriesFragment : BaseMvvmFragment<CountriesViewModel>(CountriesViewModel::class.java) {

    companion object {
        fun newInstance(): CountriesFragment {
            return CountriesFragment()
        }
    }

    override val layoutId: Int = R.layout.fragment_countries

}