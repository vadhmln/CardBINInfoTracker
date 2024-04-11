package ru.test.sample.network

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import ru.test.sample.network.model.CardInfoResponse

interface CardInfoService {

    @GET("{bin}")
    suspend fun getCardInfo(
        @Path("bin") bin: String,
    ): ApiResponse<CardInfoResponse>
}