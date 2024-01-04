package com.konstantink.intlcard.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.domain.repositories.CardSetRepository
import com.konstantink.intlcard.domain.usecases.CreateCardSetUseCase
import com.konstantink.intlcard.domain.usecases.CreateCardUseCase
import com.konstantink.intlcard.domain.usecases.DeleteCardSetUseCase
import com.konstantink.intlcard.domain.usecases.GetCardSetListUseCase
import com.konstantink.intlcard.domain.usecases.GetCardsUseCase
import com.konstantink.intlcard.domain.usecases.UpdateCardSetUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CardSetViewModel @Inject constructor(private val
    cardSetRepository: CardSetRepository) : ViewModel(){
    private val createCardSetUseCase = CreateCardSetUseCase(cardSetRepository)
    private val createCardUseCase = CreateCardUseCase(cardSetRepository)
    private val deleteCardSetUseCase = DeleteCardSetUseCase(cardSetRepository)
    private val updateCardSetUseCase = UpdateCardSetUseCase(cardSetRepository)
    private val getCardsUseCase = GetCardsUseCase(cardSetRepository)
    val cardSetList: LiveData<List<CardSet>> by lazy {
        GetCardSetListUseCase(cardSetRepository).getCardSetList()
    }

    private val _cardList = MutableLiveData<List<Card>>()
    val cardList: LiveData<List<Card>> by lazy {
        GetCardsUseCase(cardSetRepository).getCards()
    }




    private val _shouldScreenClose = MutableLiveData<Boolean>()
    val shouldScreenClose: LiveData<Boolean>

        get() = _shouldScreenClose

    var currentCardSet : CardSet? = CardSet()


    fun createCardSet(originLanguage: String, targetLanguage: String, comment: String) {
        startWork()
        val cardSet = CardSet(
            originLanguage = originLanguage,
            targetLanguage = targetLanguage,
            comment = comment
        )

        viewModelScope.launch(Dispatchers.IO) {
            createCardSetUseCase.createCardSet(cardSet)
            finishWork()
        }
    }

    fun deleteCardSet(cardSetId: Int) {
        viewModelScope.launch {
            deleteCardSetUseCase.deleteCardSet(cardSetId)
        }
    }



    fun setActiveCardSet(cardSet: CardSet) {
        currentCardSet = cardSet
    }

    fun getCards() {
        println(_cardList.value)
        Log.d("VM", "Current Card value us ${_cardList.value}")
    }

    fun clearCurrentCardSet() {
        currentCardSet = null
    }

    fun createCard(word : String, translation : String, context: String) {
        val card =
            Card(
                cardSetId = currentCardSet?.id,
                origin = word,
                translation = translation,
                targetLanguage = "English",
                sourceLanguage = "Russian",
                context = context
            )
            if (card != null) {
                viewModelScope.launch(Dispatchers.IO) {
                    createCardUseCase.createCard(card)
                }
            }


    }

    private fun finishWork() {
        _shouldScreenClose.postValue(true)
    }

    private fun startWork() {
        _shouldScreenClose.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }


}