package com.valery.myapplication.dagger

import com.valery.myapplication.app.App
import com.valery.myapplication.dagger.components.AppComponent
import com.valery.myapplication.dagger.components.DaggerAppComponent
import com.valery.myapplication.dagger.components.SessionComponent
import com.valery.myapplication.dagger.modules.AppModule

object DaggerManager {

    var appComponent: AppComponent? = null
    var sessionComponent: SessionComponent? = null

    fun initAppComponent(app: App) = DaggerAppComponent.builder()
        .appModule(AppModule(app))
        .build()
        .apply {
            appComponent = this
        }

    fun releaseAppComponent() {
        appComponent = null
    }

    fun startSession(app: App) = initAppComponent(app)
        .apply {
            sessionComponent = sessionComponent()
        }

    fun stopSession() {
        sessionComponent = null
    }
}