package com.konstantink.intlcard.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.konstantink.intlcard.data.dbModels.CardDbModel
import com.konstantink.intlcard.data.dbModels.CardSetDbModel

@Dao
interface CardSetDao {

        @Query("SELECT * FROM card_sets")
        fun getCardSetList(): LiveData<List<CardSetDbModel>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun addCardSet(cardSetDbModel: CardSetDbModel)

        @Query("DELETE FROM card_sets WHERE id=:cardSetId")
        fun deleteCardSet(cardSetId: Int)

        @Query("SELECT * FROM card_sets WHERE id=:cardSetId LIMIT 1")
        fun getCardSet(cardSetId: Int): CardSetDbModel

        @Update
        fun updateCardSet(cardSetDbModel: CardSetDbModel)
    }
