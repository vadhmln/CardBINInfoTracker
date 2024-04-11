package ru.test.sample.network

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import ru.test.sample.network.model.CardInfoResponse

interface CardInfoService {

    @GET("{cardNumber}")
    suspend fun getCardInfo(
        @Path("cardNumber") cardNumber: String,
    ): ApiResponse<CardInfoResponse>
}