package com.valery.myapplication.ui.main

import com.valery.myapplication.R
import com.valery.myapplication.ui.base.activity.BaseActivity
import com.valery.myapplication.ui.countries.CountriesFragment

class MainActivity : BaseActivity(), MainView {

    override val layoutId: Int = R.layout.activity_main

    override val containerId: Int = R.id.flContent

    override fun onLoadInitialContent() {
        openCountriesList()
    }

    override fun openCountriesList() {
        replaceFragment(CountriesFragment.newInstance())
    }
}
