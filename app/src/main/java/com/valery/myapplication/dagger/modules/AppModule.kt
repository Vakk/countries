package com.valery.myapplication.dagger.modules

import android.content.Context
import com.valery.myapplication.app.App
import com.valery.myapplication.dagger.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: App) {

    @AppScope
    @Provides
    fun provideContext(): Context = app

    @AppScope
    @Provides
    fun provideApplication(): App = app

}