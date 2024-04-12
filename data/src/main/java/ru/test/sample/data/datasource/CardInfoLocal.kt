package ru.test.sample.data.datasource

import kotlinx.coroutines.flow.Flow
import ru.test.sample.data.model.CardInfoDataModel

interface CardInfoLocal {

    suspend fun insert(cardInfo: CardInfoDataModel)

    fun getAllCards(): Flow<List<CardInfoDataModel>>
}