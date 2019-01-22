package com.valery.myapplication.providers

import com.valery.myapplication.model.CountryModel
import io.reactivex.Single

interface CountriesProvider {
    fun getAllCountries(): Single<List<CountryModel>>
}

class CountriesProviderImpl : CountriesProvider {
    override fun getAllCountries(): Single<List<CountryModel>> {
        return Single.fromCallable {
            val result = mutableListOf<CountryModel>()
            result.add(CountryModel("Canada"))
            result.add(CountryModel("USA"))
            return@fromCallable result
        }
    }
}