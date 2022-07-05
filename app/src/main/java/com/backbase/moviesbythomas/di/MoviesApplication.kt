package com.backbase.moviesbythomas.di

import android.app.Application
import com.backbase.moviesbythomas.di.modules.moviesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoviesApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MoviesApplication)
            modules(arrayListOf(moviesModule))
        }
    }

}