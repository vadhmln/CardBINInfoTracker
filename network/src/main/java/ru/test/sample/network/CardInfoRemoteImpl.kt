package ru.test.sample.network

import com.skydoves.sandwich.mapSuccess
import ru.test.sample.data.datasource.CardInfoRemote
import ru.test.sample.network.mapper.CardInfoRemoteToDataMapper

class CardInfoRemoteImpl(
    private val cardInfoService: CardInfoService,
    private val cardInfoRemoteToDataMapper: CardInfoRemoteToDataMapper,
): CardInfoRemote {

    override suspend fun getCardInfo(bin: String) =
        cardInfoService.getCardInfo(bin).mapSuccess(cardInfoRemoteToDataMapper::toData)
}