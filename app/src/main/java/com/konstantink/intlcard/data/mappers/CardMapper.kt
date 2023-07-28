package com.konstantink.intlcard.data.mappers

import com.konstantink.intlcard.data.dbModels.CardDbModel
import com.konstantink.intlcard.domain.entities.Card

object CardMapper: IntlCardMapper<CardDbModel, Card> {


    override fun mapEntityToDbModel(card: Card) = CardDbModel(
        id = card.id,
        origin = card.origin,
        translation = card.translation,
        context = card.context
    )

    override fun mapDbModelToEntity(cardDbModel: CardDbModel) = Card(
        id = cardDbModel.id,
        origin = cardDbModel.origin,
        translation = cardDbModel.translation,
        context = cardDbModel.context
    )

    override fun mapListDbModelToListEntity(dbModelList: List<CardDbModel>)  = dbModelList.map {
        mapDbModelToEntity(it)
    }


    override fun mapListEntityToListDbModel(entityList: List<Card>) = entityList.map {
        mapEntityToDbModel(it)
    }


}