package com.valery.myapplication.dagger.components

import com.valery.myapplication.dagger.modules.ApiModule
import com.valery.myapplication.dagger.modules.ManagersModule
import com.valery.myapplication.dagger.modules.RepositoryModule
import com.valery.myapplication.ui.countries.CountriesViewModel
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ApiModule::class,
        ManagersModule::class,
        RepositoryModule::class
    ]
)
interface SessionComponent {
    fun inject(countriesViewModel: CountriesViewModel)
}