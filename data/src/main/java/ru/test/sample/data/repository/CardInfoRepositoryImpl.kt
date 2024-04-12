package ru.test.sample.data.repository

import android.util.Log
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.test.sample.data.datasource.CardInfoLocal
import ru.test.sample.data.datasource.CardInfoRemote
import ru.test.sample.data.mapper.CardInfoDataToDomainMapper
import ru.test.sample.data.mapper.CardInfoDomainToDataMapper
import ru.test.sample.domain.model.CardInfoDomainModel
import ru.test.sample.domain.repository.CardInfoRepository

class CardInfoRepositoryImpl(
    private val remoteDataSource: CardInfoRemote,
    private val cardInfoLocal: CardInfoLocal,
    private val cardInfoDataToDomainMapper: CardInfoDataToDomainMapper,
    private val cardInfoDomainToDataMapper: CardInfoDomainToDataMapper,
) : CardInfoRepository {

    override fun getBinInfo(bin: String) = flow {
        val response = remoteDataSource.getCardInfo(bin)

        response.suspendOnSuccess {
            val card = cardInfoDataToDomainMapper.toDomain(data)

            cardInfoLocal.insert(cardInfoDomainToDataMapper.toData(card))

            emit(card)
        }

    }.flowOn(Dispatchers.IO)

    override fun getAllCards(): Flow<List<CardInfoDomainModel>> =
        cardInfoLocal.getAllCards().map { list ->
            list.map(cardInfoDataToDomainMapper::toDomain)
        }
}
