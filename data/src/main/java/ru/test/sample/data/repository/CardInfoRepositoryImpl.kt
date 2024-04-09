package ru.test.sample.data.repository

import ru.test.sample.data.datasource.CardInfoDataSource
import ru.test.sample.data.mapper.CardInfoDataToDomainMapper
import ru.test.sample.domain.model.CardInfoDomainModel
import ru.test.sample.domain.repository.CardInfoRepository

class CardInfoRepositoryImpl(
    private val dataSource: CardInfoDataSource,
    private val cardInfoDataToDomainMapper: CardInfoDataToDomainMapper
) : CardInfoRepository {

    override suspend fun getBinInfo(bin: String): Result<CardInfoDomainModel> {
        val binResponse = dataSource.getBinInfo(bin)
        return binResponse.map(cardInfoDataToDomainMapper::toDomain)
    }
}
