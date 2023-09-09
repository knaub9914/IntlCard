package com.konstantink.intlcard.domain.usecases

import androidx.lifecycle.LiveData
import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.repositories.CardRepository

class GetCardsUseCase(private val repository: CardRepository) {

    fun getCards(cardSetId: Int): LiveData<List<Card>> {
        return repository.getCards(cardSetId)
    }
}