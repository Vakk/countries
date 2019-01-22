package com.valery.myapplication.dagger.modules

import com.valery.myapplication.converters.CountryBeanConverterImpl
import com.valery.myapplication.converters.CountryBeanConverter
import com.valery.myapplication.dagger.scope.SessionScope
import dagger.Module
import dagger.Provides

@Module
class ConvertersModule {

    @SessionScope
    @Provides
    fun provideCountriesBeanConverter(): CountryBeanConverter = CountryBeanConverterImpl()
}