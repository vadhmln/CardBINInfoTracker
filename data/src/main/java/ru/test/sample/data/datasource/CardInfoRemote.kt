package ru.test.sample.data.datasource

import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow
import ru.test.sample.data.model.CardInfoDataModel

interface CardInfoRemote {

    suspend fun getCardInfo(bin: String): ApiResponse<CardInfoDataModel>
}