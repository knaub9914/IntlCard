package com.konstantink.intlcard.domain.repositories

import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.entities.CardSet

interface CardRepository {

    fun getCardSets() : List<CardSet>

    fun getCardSet(cardSetId: String) : CardSet

    fun createCardSet(cardSet: CardSet)

    fun updateCardSet(cardSet: CardSet)

    fun deleteCardSet(cardSet: CardSet)

    fun getCards() : List<Card>

    fun getCard(cardId: String) : Card

    fun createCard(card: Card)

    fun updateCard(card: Card)

    fun deleteCard(card: Card)

}