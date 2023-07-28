package com.konstantink.intlcard.domain.entities

import java.util.*

data class CardSet(
    var id: Int = DEFAULT_ID,
    val cards: List<Card>,
    val cardCount: Int = cards.count()
) {

    companion object {
        const val DEFAULT_ID: Int = 0
    }
}
