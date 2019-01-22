package com.valery.myapplication.api.modules

import com.valery.myapplication.api.beans.CountryBean
import com.valery.myapplication.api.services.CountriesApiService
import io.reactivex.Single

interface CountriesApiModule {
    fun getAllCountries(): Single<List<CountryBean>>
}

class CountriesApiModuleImpl(private val countriesApiService: CountriesApiService) : CountriesApiModule {
    override fun getAllCountries(): Single<List<CountryBean>> {
        return countriesApiService.getAllCountries()
    }
}