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
import com.konstantink.intlcard.domain.usecases.DeleteCardSetUseCase
import com.konstantink.intlcard.domain.usecases.GetCardSetListUseCase
import com.konstantink.intlcard.domain.usecases.GetCardsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardSetViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CardRepositoryImpl(application)

    private val createCardSetUseCase = CreateCardSetUseCase(repository)
    private val getCardSetListUseCase = GetCardSetListUseCase(repository)
    private val deleteCardSetUseCase = DeleteCardSetUseCase(repository)


    private val _cardSetList = getCardSetListUseCase.getCardSetList()
    val cardSetList: LiveData<List<CardSet>>
        get() = _cardSetList

    private val _shouldScreenClose = MutableLiveData<Boolean>()
    val shouldScreenClose : LiveData<Boolean>
        get() = _shouldScreenClose

    private val _currentCardSet = MutableLiveData<CardSet>()
    val currentCardSet : LiveData<CardSet>
        get() = _currentCardSet


    fun createCardSet(originLanguage: String, targetLanguage: String, comment: String) {

        startWork()
        val cardSet = CardSet(
            originLanguage = originLanguage, targetLanguage = targetLanguage,
            comment = comment
        )

        viewModelScope.launch() {
            createCardSetUseCase.createCardSet(cardSet)
        }
        finishWork()
    }

    fun deleteCardSet(cardSetId: Int){
        viewModelScope.launch {
            deleteCardSetUseCase.deleteCardSet(cardSetId)
        }

    }

    fun accessCardSet(cardSet: CardSet){
        _currentCardSet.value = cardSet
    }

    private fun finishWork() {
        _shouldScreenClose.value = true
    }


    private fun startWork() {
        _shouldScreenClose.value = false
    }

}