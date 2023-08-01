package com.konstantink.intlcard.domain.usecases

import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.domain.repositories.CardRepository

class CreateCardSetUseCase(private val repository: CardRepository) {

    suspend fun createCardSet(cardSet: CardSet) {
        repository.createCardSet(cardSet)
    }
}