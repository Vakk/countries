package com.valery.myapplication.providers

import com.valery.myapplication.api.modules.CountriesApiModule
import com.valery.myapplication.converters.CountryBeanConverter
import com.valery.myapplication.model.CountryModel
import com.valery.myapplication.repository.CountriesRepository
import io.reactivex.Single

interface CountriesProvider {
    fun getAllCountries(): Single<List<CountryModel>>

    fun getCountriesBy(codes: List<String>): Single<List<CountryModel>>

    fun getBordersOf(countryModel: CountryModel): Single<List<CountryModel>>
}

class CountriesProviderImpl(
    private val countriesRepository: CountriesRepository,
    private val countriesModule: CountriesApiModule,
    private val countryBeanConverter: CountryBeanConverter
) : CountriesProvider {

    override fun getAllCountries(): Single<List<CountryModel>> {
        return countriesModule.getAllCountries()
            .map { countryBeanConverter.convert(it) }
    }

    override fun getCountriesBy(codes: List<String>): Single<List<CountryModel>> {
        return countriesModule.getCountries(codes)
            .map { countryBeanConverter.convert(it) }
    }

    override fun getBordersOf(countryModel: CountryModel): Single<List<CountryModel>> {
        return getCountriesBy(countryModel.borders)
    }
}