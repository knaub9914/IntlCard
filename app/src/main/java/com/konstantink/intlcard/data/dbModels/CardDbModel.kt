package com.konstantink.intlcard.data.dbModels

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cards")
data class CardDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val origin: String,
    val translation: String,
    val context: String
) {
}