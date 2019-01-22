package com.valery.myapplication.ui.main

import com.valery.myapplication.model.CountryModel

interface MainView {
    fun openCountriesList()

    fun openBorders(countryModel: CountryModel)
}