package com.konstantink.intlcard.domain.entities

import java.util.*

data class Card(
    var id: Int = DEFAULT_ID,
    val origin: String,
    val translation: String,
    val context: String
    ){


    companion object {
        const val DEFAULT_ID: Int = 0
    }
}
