package com.konstantink.intlcard.di

import android.content.Context
import com.konstantink.intlcard.di.factories.CardSetViewModelFactory
import com.konstantink.intlcard.presentation.MainActivity
import com.konstantink.intlcard.presentation.viewmodels.CardSetViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
    fun cardViewModel(): CardSetViewModel
    fun cardSetViewModelsFactory(): CardSetViewModelFactory
}