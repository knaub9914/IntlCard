package com.konstantink.intlcard.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.konstantink.intlcard.data.dbModels.CardDbModel

@Dao
interface CardDao {

    @Query("SELECT * FROM cards where cardSetId = :value")
    fun getCardList(value: Int): LiveData<List<CardDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCard(cardDbModel: CardDbModel)

    @Query("DELETE FROM cards WHERE id=:cardId")
    fun deleteCard(cardId: Int)

    @Query("SELECT * FROM cards WHERE id=:cardId LIMIT 1")
    fun getCard(cardId: Int): CardDbModel
}
