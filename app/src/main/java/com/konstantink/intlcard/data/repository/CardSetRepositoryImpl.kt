package com.konstantink.intlcard.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.konstantink.intlcard.data.databases.AppDatabase
import com.konstantink.intlcard.data.mappers.CardMapper
import com.konstantink.intlcard.data.mappers.CardSetMapper
import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.domain.repositories.CardSetRepository
import kotlinx.coroutines.flow.Flow

class CardSetRepositoryImpl(context: Context): CardSetRepository {

    private val cardDao = AppDatabase.getInstance(context).cardDao()
    private val cardSetDao = AppDatabase.getInstance(context).cardSetDao()
    override fun getCardSets(): LiveData<List<CardSet>> =
        Transformations.map(
        cardSetDao.getCardSetList()){
        CardSetMapper.mapListDbModelToListEntity(it)
    }



     override  fun getCardSet(cardSetId: Int): CardSet {
        val dbModel = cardSetDao.getCardSet(cardSetId)
        return CardSetMapper.mapDbModelToEntity(dbModel)
    }

    override suspend fun createCardSet(cardSet: CardSet) {
        val dbModel = CardSetMapper.mapEntityToDbModel(cardSet)
        cardSetDao.addCardSet(dbModel)
    }

    override suspend fun updateCardSet(cardSet: CardSet) {
        val dbModel = CardSetMapper.mapEntityToDbModel(cardSet)
        cardSetDao.updateCardSet(dbModel)
    }

    override suspend fun deleteCardSet(cardSetInt: Int) {
        cardSetDao.deleteCardSet(cardSetInt)
    }

    override fun getCards(): LiveData<List<Card>> = Transformations.map(
        cardDao.getCardList()) {
        CardMapper.mapListDbModelToListEntity(it)
    }
    override fun getCard(cardId: Int): Card {
        val dbModel = cardDao.getCard(cardId)
        return CardMapper.mapDbModelToEntity(dbModel)
    }

    override suspend fun createCard(card: Card) {
        val dbModel = CardMapper.mapEntityToDbModel(card)
        cardDao.addCard(dbModel)

    }

    override suspend fun updateCard(card: Card) {
        val dbModel = CardMapper.mapEntityToDbModel(card)
        cardDao.addCard(dbModel)
    }

    override suspend  fun deleteCard(cardId: Int) {
        cardDao.deleteCard(cardId)
    }
}