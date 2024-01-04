package com.konstantink.intlcard.domain.repositories

import androidx.lifecycle.LiveData
import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.entities.CardSet

interface CardSetRepository {

    fun getCardSets() : LiveData<List<CardSet>>

    fun getCardSet(cardSetId: Int) : CardSet

    suspend fun createCardSet(cardSet: CardSet)

    suspend fun updateCardSet(cardSet: CardSet)

    suspend fun deleteCardSet(cardSetId: Int)

    fun getCards() : LiveData<List<Card>>

    fun getCard(cardId: Int) : Card

    suspend fun createCard(card: Card)

    suspend fun updateCard(card: Card)

    suspend fun deleteCard(cardId: Int)

}