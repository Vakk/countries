package com.valery.myapplication.dagger.modules

import com.valery.myapplication.api.services.CountriesApiService
import com.valery.myapplication.dagger.scope.SessionScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiServicesModule {
    @SessionScope
    @Provides
    fun countriesApiService(retrofit: Retrofit): CountriesApiService =
        retrofit.create(CountriesApiService::class.java)
}