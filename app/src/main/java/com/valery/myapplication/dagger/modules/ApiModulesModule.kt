package com.valery.myapplication.dagger.modules

import com.valery.myapplication.api.modules.CountriesApiModule
import com.valery.myapplication.api.modules.CountriesApiModuleImpl
import com.valery.myapplication.api.services.CountriesApiService
import com.valery.myapplication.dagger.scope.SessionScope
import dagger.Module
import dagger.Provides

@Module
class ApiModulesModule {
    @SessionScope
    @Provides
    fun countriesApiModule(countriesApiService: CountriesApiService): CountriesApiModule =
        CountriesApiModuleImpl(countriesApiService = countriesApiService)
}