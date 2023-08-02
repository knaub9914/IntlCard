package com.konstantink.intlcard.presentation.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konstantink.intlcard.data.repository.CardRepositoryImpl
import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.domain.usecases.CreateCardSetUseCase
import com.konstantink.intlcard.domain.usecases.GetCardSetListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardSetViewModel(application: Application): AndroidViewModel(application) {

    private val repository = CardRepositoryImpl(application)

    private val createCardSetUseCase = CreateCardSetUseCase(repository)
    private val getCardSetListUseCase = GetCardSetListUseCase(repository)

    var cardSetList = getCardSetListUseCase.getCardSetList()

    fun createCardSetTest(originLanguage: String, targetLanguage: String, comment: String) {

        val cardSet = CardSet(
            originLanguage = originLanguage, targetLanguage = targetLanguage,
            comment = comment)

        viewModelScope.launch() {
            createCardSetUseCase.createCardSet(cardSet)
        }
    }


    fun createCardSet(originLanguage: String, targetLanguage: String, comment: String) {

        val cardSet = CardSet(
             originLanguage = originLanguage, targetLanguage = targetLanguage,
            comment = comment)

        viewModelScope.launch() {
            createCardSetUseCase.createCardSet(cardSet)
        }
    }


}