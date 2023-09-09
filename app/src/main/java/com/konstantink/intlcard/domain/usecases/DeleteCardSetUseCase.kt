package com.konstantink.intlcard.domain.usecases

import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.domain.repositories.CardRepository

class DeleteCardSetUseCase(private val repository: CardRepository) {

    suspend fun deleteCardSet(cardSetId: Int) {
        repository.deleteCardSet(cardSetId)
    }
}