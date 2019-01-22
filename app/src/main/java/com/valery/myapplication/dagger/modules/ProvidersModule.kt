package com.valery.myapplication.dagger.modules

import com.valery.myapplication.api.modules.CountriesApiModule
import com.valery.myapplication.converters.CountryBeanConverter
import com.valery.myapplication.dagger.scope.SessionScope
import com.valery.myapplication.providers.CountriesProvider
import com.valery.myapplication.providers.CountriesProviderImpl
import com.valery.myapplication.repository.CountriesRepository
import dagger.Module
import dagger.Provides

@Module
class ProvidersModule {

    @SessionScope
    @Provides
    fun provideCountriesProvider(
        countriesModule: CountriesApiModule,
        countryBeanConverter: CountryBeanConverter,
        countriesRepository: CountriesRepository
    ): CountriesProvider = CountriesProviderImpl(
        countriesModule = countriesModule,
        countryBeanConverter = countryBeanConverter,
        countriesRepository = countriesRepository
    )

}