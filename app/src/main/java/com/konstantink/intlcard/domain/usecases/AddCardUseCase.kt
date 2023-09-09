package com.konstantink.intlcard.domain.usecases

import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.repositories.CardRepository

class AddCardUseCase(private val repository: CardRepository) {
    suspend fun addCard(card: Card){
        repository.createCard(card)
    }
}