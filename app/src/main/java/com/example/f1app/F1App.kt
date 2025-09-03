package com.example.f1app

import android.app.Application
import com.example.f1app.di.dataModule
import com.example.f1app.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class F1App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@F1App)
            modules(dataModule, presentationModule)
        }
    }
}