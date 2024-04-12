package ru.test.sample.domain.repository

import ru.test.sample.domain.model.CardInfoDomainModel
import kotlinx.coroutines.flow.Flow

interface CardInfoRepository {

    fun getBinInfo(bin: String): Flow<CardInfoDomainModel>

    fun getAllCards(): Flow<List<CardInfoDomainModel>>
}