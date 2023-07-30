package com.konstantink.intlcard.data.dbModels

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity(tableName = "cards")
@Serializable
data class CardDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val origin: String = "",
    val translation: String = "",
    val targetLanguage: String = DEFAULT_LANGUAGE,
    val sourceLanguage: String = DEFAULT_LANGUAGE,
    val context: String = ""
) {

    companion object {
        val DEFAULT_LANGUAGE: String = "English"
    }
}