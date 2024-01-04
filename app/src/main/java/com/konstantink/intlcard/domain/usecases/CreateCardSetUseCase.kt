package com.konstantink.intlcard.domain.usecases

import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.domain.repositories.CardSetRepository

class CreateCardSetUseCase(private val repository: CardSetRepository) {

    suspend fun createCardSet(cardSet: CardSet) {
        repository.createCardSet(cardSet)
    }
}