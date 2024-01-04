package com.konstantink.intlcard.domain.usecases

import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.repositories.CardSetRepository
import javax.inject.Inject

class CreateCardUseCase @Inject constructor(private val repository: CardSetRepository) {
    suspend fun createCard(card: Card){
        repository.createCard(card)
    }
}