package com.konstantink.intlcard.domain.entities

import com.konstantink.intlcard.data.dbModels.CardDbModel
import com.konstantink.intlcard.data.dbModels.CardSetDbModel
import java.util.*

data class CardSet(
    var id: Int = DEFAULT_ID,
    val cards: List<Card>? = DEFAULT_CARD_LIST,
    val comment: String = "",
    val originLanguage: String = DEFAULT_LANGUAGE,
    val targetLanguage: String = DEFAULT_LANGUAGE,

    ) {

    companion object {
        const val DEFAULT_ID: Int = 0
        val DEFAULT_LANGUAGE: String = "English"
        val DEFAULT_CARD_LIST = listOf<Card>()
    }
}
