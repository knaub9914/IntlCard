package com.konstantink.intlcard.domain.entities

import java.util.*

data class Card(
    val id: String = UUID.randomUUID().toString(),
    val origin: String,
    val translation: String,
    val context: String
    )
