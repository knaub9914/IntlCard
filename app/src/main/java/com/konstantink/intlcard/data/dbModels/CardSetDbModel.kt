package com.konstantink.intlcard.data.dbModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_sets")
data class CardSetDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val cards: List<CardDbModel>,
    val cardCount: Int = cards.count()
) {
}