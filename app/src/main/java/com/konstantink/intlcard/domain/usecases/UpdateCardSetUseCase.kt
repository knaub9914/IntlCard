package com.konstantink.intlcard.domain.usecases

import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.domain.repositories.CardSetRepository
import javax.inject.Inject

class UpdateCardSetUseCase @Inject constructor(
    private val repository: CardSetRepository) {
    suspend fun updateCardSet(cardSet: CardSet) {
        repository.updateCardSet(cardSet)
    }
}