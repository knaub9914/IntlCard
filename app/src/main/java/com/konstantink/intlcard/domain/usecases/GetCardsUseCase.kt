package com.konstantink.intlcard.domain.usecases

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.repositories.CardSetRepository
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val repository: CardSetRepository) {
    fun getCards(): LiveData<List<Card>> {
        return repository.getCards()
    }
}