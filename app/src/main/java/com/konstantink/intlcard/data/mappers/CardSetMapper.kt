package com.konstantink.intlcard.data.mappers

import com.konstantink.intlcard.data.dbModels.CardSetDbModel
import com.konstantink.intlcard.domain.entities.CardSet

object CardSetMapper: IntlCardMapper<CardSetDbModel, CardSet> {
    override fun mapEntityToDbModel(entity: CardSet) = CardSetDbModel (
        id = entity.id,
        targetLanguage = entity.targetLanguage,
        originLanguage = entity.originLanguage,
        comment = entity.comment
    )



    override fun mapDbModelToEntity(dbModel: CardSetDbModel) = CardSet (
        id = dbModel.id,
        targetLanguage = dbModel.targetLanguage,
        originLanguage = dbModel.originLanguage,
        comment = dbModel.comment
        )

    override fun mapListDbModelToListEntity(dbModelList: List<CardSetDbModel>) = dbModelList.map {
        mapDbModelToEntity(it)
    }


    override fun mapListEntityToListDbModel(entityList: List<CardSet>)  = entityList.map {
        mapEntityToDbModel(it)
    }
}