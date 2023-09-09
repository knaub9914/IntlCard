package com.konstantink.intlcard.data.mappers

import com.konstantink.intlcard.data.dbModels.CardDbModel
import com.konstantink.intlcard.domain.entities.Card

object CardMapper: IntlCardMapper<CardDbModel, Card> {


    override fun mapEntityToDbModel(card: Card) = CardDbModel(
        id = card.id,
        cardSetId = card.cardSetId,
        origin = card.origin,
        translation = card.translation,
        context = card.context,
        targetLanguage = card.targetLanguage,
        sourceLanguage = card.sourceLanguage
    )

    override fun mapDbModelToEntity(cardDbModel: CardDbModel) = Card(
        id = cardDbModel.id,
        cardSetId = cardDbModel.cardSetId,
        origin = cardDbModel.origin,
        translation = cardDbModel.translation,
        context = cardDbModel.context,
        targetLanguage = cardDbModel.targetLanguage,
        sourceLanguage = cardDbModel.sourceLanguage
    )

    override fun mapListDbModelToListEntity(dbModelList: List<CardDbModel>)  = dbModelList.map {
        mapDbModelToEntity(it)
    }


    override fun mapListEntityToListDbModel(entityList: List<Card>) = entityList.map {
        mapEntityToDbModel(it)
    }


}