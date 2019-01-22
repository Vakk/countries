package com.valery.myapplication.ui.main

import android.view.View
import com.valery.myapplication.model.CountryModel

interface MainView {
    fun openCountriesList()

    fun openBorders(countryModel: CountryModel, transitionPairs: Array<Pair<View, String>> = arrayOf())
}