package com.konstantink.intlcard.domain.usecases

import androidx.lifecycle.LiveData
import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.domain.repositories.CardSetRepository

class GetCardSetListUseCase(private val repository: CardSetRepository) {

  fun getCardSetList(): LiveData<List<CardSet>>{
        return repository.getCardSets()
    }
}