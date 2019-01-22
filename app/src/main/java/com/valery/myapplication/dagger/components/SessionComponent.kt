package com.valery.myapplication.dagger.components

import com.valery.myapplication.dagger.modules.*
import com.valery.myapplication.dagger.scope.SessionScope
import com.valery.myapplication.ui.borders.BordersViewModel
import com.valery.myapplication.ui.countries.CountriesViewModel
import dagger.Subcomponent

@SessionScope
@Subcomponent(
    modules = [
        ApiModulesModule::class,
        ApiServicesModule::class,
        ManagersModule::class,
        RepositoryModule::class,
        ProvidersModule::class,
        ConvertersModule::class,
        NetworkModule::class
    ]
)
interface SessionComponent {
    fun inject(bordersViewModel: BordersViewModel)
    fun inject(countriesViewModel: CountriesViewModel)
}