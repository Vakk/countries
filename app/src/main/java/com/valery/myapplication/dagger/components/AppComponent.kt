package com.valery.myapplication.dagger.components

import com.valery.myapplication.dagger.modules.AppModule
import dagger.Component

@Component(modules = [
    AppModule::class
])
interface AppComponent {
    fun sessionComponent(): SessionComponent
}