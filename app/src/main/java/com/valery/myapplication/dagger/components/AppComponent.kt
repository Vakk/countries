package com.valery.myapplication.dagger.components

import com.valery.myapplication.dagger.modules.AppModule
import com.valery.myapplication.dagger.scope.AppScope
import dagger.Component

@AppScope
@Component(modules = [
    AppModule::class
])
interface AppComponent {
    fun sessionComponent(): SessionComponent
}