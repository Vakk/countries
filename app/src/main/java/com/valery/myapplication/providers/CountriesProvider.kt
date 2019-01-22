package com.valery.myapplication.providers

import com.valery.myapplication.api.modules.CountriesApiModule
import com.valery.myapplication.converters.CountryBeanConverter
import com.valery.myapplication.model.CountryModel
import io.reactivex.Single

interface CountriesProvider {
    fun getAllCountries(): Single<List<CountryModel>>
}

class CountriesProviderImpl(
    private val countriesModule: CountriesApiModule,
    private val countryBeanConverter: CountryBeanConverter
) : CountriesProvider {

    override fun getAllCountries(): Single<List<CountryModel>> {
        return countriesModule.getAllCountries()
            .map { countryBeanConverter.convert(it) }
    }

}