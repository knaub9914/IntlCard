package com.konstantink.intlcard.domain.usecases

import com.konstantink.intlcard.domain.repositories.CardSetRepository

class DeleteCardSetUseCase(private val repository: CardSetRepository) {

    suspend fun deleteCardSet(cardSetId: Int) {
        repository.deleteCardSet(cardSetId)
    }
}