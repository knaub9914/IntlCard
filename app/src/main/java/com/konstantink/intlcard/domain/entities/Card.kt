package com.konstantink.intlcard.domain.entities

import com.konstantink.intlcard.data.dbModels.CardDbModel
import java.util.*

data class Card(
    var id: Int = DEFAULT_ID,
    val origin: String = "",
    val translation: String = "",
    val targetLanguage: String = CardDbModel.DEFAULT_LANGUAGE,
    val sourceLanguage: String = CardDbModel.DEFAULT_LANGUAGE,
    val context: String = ""
    ){


    companion object {
        const val DEFAULT_ID: Int = 0
        val DEFAULT_LANGUAGE: String = "English"
    }
}
