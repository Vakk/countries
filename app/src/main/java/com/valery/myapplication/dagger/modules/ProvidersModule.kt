package com.valery.myapplication.dagger.modules

import com.valery.myapplication.dagger.scope.SessionScope
import com.valery.myapplication.providers.CountriesProvider
import com.valery.myapplication.providers.CountriesProviderImpl
import dagger.Module
import dagger.Provides

@Module
class ProvidersModule {

    @SessionScope
    @Provides
    fun provideCountriesProvider(): CountriesProvider = CountriesProviderImpl()

}