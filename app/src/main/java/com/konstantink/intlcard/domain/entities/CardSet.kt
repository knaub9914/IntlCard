package com.konstantink.intlcard.domain.entities

import java.util.*

data class CardSet(
    val id: String = UUID.randomUUID().toString(),
    val cards: List<Card>,
    val cardCount: Int = cards.count()
)
