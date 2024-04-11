package ru.test.sample.network

import android.util.Log
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mapSuccess
import ru.test.sample.data.datasource.CardInfoRemote
import ru.test.sample.data.model.CardInfoDataModel
import ru.test.sample.network.mapper.CardInfoRemoteToDataMapper

class CardInfoRemoteImpl(
    private val cardInfoService: CardInfoService,
    private val cardInfoRemoteToDataMapper: CardInfoRemoteToDataMapper,
): CardInfoRemote {

    override suspend fun getCardInfo(bin: String): ApiResponse<CardInfoDataModel> {
       val cardInfo = cardInfoService.getCardInfo(bin).mapSuccess(cardInfoRemoteToDataMapper::toData)
        Log.d("CardInfoRemoteImpl", "$cardInfo")
        return cardInfo
    }
}