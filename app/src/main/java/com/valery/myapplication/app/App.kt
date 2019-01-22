package com.valery.myapplication.app

import android.app.Application
import com.valery.myapplication.dagger.DaggerManager

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        DaggerManager.startSession(this)
    }
}