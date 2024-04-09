package ru.test.sample.domain.repository

import ru.test.sample.domain.model.CardInfoDomainModel

interface CardInfoRepository {

    suspend fun getBinInfo(bin: String): Result<CardInfoDomainModel>
}