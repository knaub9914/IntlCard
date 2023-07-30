package com.konstantink.intlcard.domain.usecases

import androidx.lifecycle.LiveData
import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.domain.repositories.CardRepository

class GetCardSetListUseCase(private val repository: CardRepository) {

    fun getCardSetList(): LiveData<List<CardSet>>{
        return repository.getCardSets()
    }
}