package com.konstantink.intlcard.data.mappers

interface IntlCardMapper<SRC, DST>{

    fun mapEntityToDbModel(entity: DST) :SRC
    fun mapDbModelToEntity(dbModel: SRC) : DST
    fun mapListDbModelToListEntity(dbModelList: List<SRC>) : List<DST>
    fun mapListEntityToListDbModel(entityList: List<DST>) : List<SRC>
}