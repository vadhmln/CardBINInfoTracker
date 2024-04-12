package ru.test.sample.database

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.test.sample.data.datasource.CardInfoLocal
import ru.test.sample.data.model.CardInfoDataModel
import ru.test.sample.database.dao.CardInfoDao
import ru.test.sample.database.mapper.CardInfoDataToDatabaseMapper
import ru.test.sample.database.mapper.CardInfoDatabaseToDataMapper

class CardInfoLocalImpl(
    private val cardInfoDao: CardInfoDao,
    private val cardInfoDataToDatabaseMapper: CardInfoDataToDatabaseMapper,
    private val cardInfoDatabaseToDataMapper: CardInfoDatabaseToDataMapper,
) : CardInfoLocal {

    override suspend fun insert(cardInfo: CardInfoDataModel) {
        val card = cardInfoDataToDatabaseMapper.toDatabase(cardInfo)
        cardInfoDao.insert(card)
    }

    override fun getAllCards(): Flow<List<CardInfoDataModel>> =
        cardInfoDao.getAllCards().map { list ->
            list.map(cardInfoDatabaseToDataMapper::toData)
        }
}