package ru.test.sample.data.repository

import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.test.sample.data.datasource.CardInfoRemote
import ru.test.sample.data.mapper.CardInfoDataToDomainMapper
import ru.test.sample.domain.model.CardInfoDomainModel
import ru.test.sample.domain.repository.CardInfoRepository

class CardInfoRepositoryImpl(
    private val remoteDataSource: CardInfoRemote,
    private val cardInfoDataToDomainMapper: CardInfoDataToDomainMapper
) : CardInfoRepository {

    override suspend fun getBinInfo(bin: String): Flow<CardInfoDomainModel> = flow {
        val response = remoteDataSource.getCardInfo(bin)

        response.suspendOnSuccess {
            val card = cardInfoDataToDomainMapper.toDomain(data)

            emit(card)
        }

    }.flowOn(Dispatchers.IO)
}
