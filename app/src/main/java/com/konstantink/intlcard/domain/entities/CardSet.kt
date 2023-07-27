package com.konstantink.intlcard.domain.entities

import java.util.*

data class CardSet(
    val cards: List<Card>,
    val cardCount: Int = cards.count()
)
