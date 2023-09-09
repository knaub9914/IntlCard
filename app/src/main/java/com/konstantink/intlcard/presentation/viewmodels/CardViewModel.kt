package com.konstantink.intlcard.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.konstantink.intlcard.data.repository.CardRepositoryImpl
import com.konstantink.intlcard.domain.usecases.AddCardUseCase

class CardViewModel(application: Application): AndroidViewModel(application) {

    private val repository = CardRepositoryImpl(application)

    private val addCardUseCase =  AddCardUseCase(repository)
}