package com.konstantink.intlcard.data.converters

import androidx.room.TypeConverter
import com.konstantink.intlcard.data.dbModels.CardDbModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CardConverter {

    @TypeConverter
    fun fromList(value : List<CardDbModel?>) = Json.encodeToString(value)

    @TypeConverter
    fun toList(value: String?) = value?.let { Json.decodeFromString<List<CardDbModel?>>(it) }
}
