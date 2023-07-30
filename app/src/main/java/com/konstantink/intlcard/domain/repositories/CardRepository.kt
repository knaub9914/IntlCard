package com.konstantink.intlcard.domain.repositories

import androidx.lifecycle.LiveData
import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.entities.CardSet

interface CardRepository {

    fun getCardSets() : LiveData<List<CardSet>>

    fun getCardSet(cardSetId: Int) : CardSet

    fun createCardSet(cardSet: CardSet)

    fun updateCardSet(cardSet: CardSet)

    fun deleteCardSet(cardSetId: Int)

    fun getCards() : LiveData<List<Card>>

    fun getCard(cardId: Int) : Card

    fun createCard(card: Card)

    fun updateCard(card: Card)

    fun deleteCard(cardId: Int)

}