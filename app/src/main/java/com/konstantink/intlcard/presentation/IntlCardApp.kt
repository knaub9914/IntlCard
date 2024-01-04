package com.konstantink.intlcard.presentation

import android.app.Application
import com.konstantink.intlcard.di.AppComponent
import com.konstantink.intlcard.di.DaggerAppComponent

open class IntlCardApp : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

}