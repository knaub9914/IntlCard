package com.konstantink.intlcard.data.dbModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_sets")
data class CardSetDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val comment: String = "",
    val originLanguage: String = DEFAULT_LANGUAGE,
    val targetLanguage: String = DEFAULT_LANGUAGE,
    val isActiveCardSet: Int = 0

    ) {
    companion object {
        const val DEFAULT_LANGUAGE: String = "English"
    }
}