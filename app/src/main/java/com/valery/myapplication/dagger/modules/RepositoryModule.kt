package com.valery.myapplication.dagger.modules

import com.valery.myapplication.dagger.scope.SessionScope
import com.valery.myapplication.repository.CountriesRepository
import com.valery.myapplication.repository.CouuntriesRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @SessionScope
    @Provides
    fun countriesRepository(): CountriesRepository = CouuntriesRepositoryImpl()

}