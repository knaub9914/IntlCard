package com.konstantink.intlcard.di

import android.content.Context
import com.konstantink.intlcard.data.repository.CardSetRepositoryImpl
import com.konstantink.intlcard.domain.repositories.CardSetRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideCardRepository(context: Context) : CardSetRepository {
        return CardSetRepositoryImpl(context)
    }


//    @Provides
//    @Singleton
//    fun provideContext() : Context {
//        return provideContext()
//    }
}