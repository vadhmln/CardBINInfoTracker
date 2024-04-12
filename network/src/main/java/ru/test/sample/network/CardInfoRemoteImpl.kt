package ru.test.sample.network

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mapSuccess
import ru.test.sample.data.datasource.CardInfoRemote
import ru.test.sample.data.model.CardInfoDataModel
import ru.test.sample.network.mapper.CardInfoRemoteToDataMapper
import ru.test.sample.network.model.CardInfoResponse

class CardInfoRemoteImpl(
    private val cardInfoService: CardInfoService,
    private val cardInfoRemoteToDataMapper: CardInfoRemoteToDataMapper,
) : CardInfoRemote {

    override suspend fun getCardInfo(bin: String): ApiResponse<CardInfoDataModel> =
        cardInfoService.getCardInfo(bin)
            .mapSuccess<CardInfoResponse, CardInfoDataModel>(cardInfoRemoteToDataMapper::toData)

}