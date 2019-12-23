package com.example.droptest.view

import android.app.Application
import com.example.droptest.di.networkModule
import com.example.droptest.di.repositoryModule
import com.example.droptest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApplication)
            modules(listOf(
                viewModelModule,
                repositoryModule,
                networkModule
            ))
        }
    }
}