package ru.test.sample.cardbininfotracker.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.test.sample.data.datasource.CardInfoRemote
import ru.test.sample.network.CardInfoRemoteImpl
import ru.test.sample.network.CardInfoService
import ru.test.sample.network.mapper.CardInfoRemoteToDataMapper
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://lookup.binlist.net/"

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        networkJson: Json,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideCardInfoService(retrofit: Retrofit): CardInfoService {
        return retrofit.create(CardInfoService::class.java)
    }

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    fun provideCardInfoRemoteToDataMapper() = CardInfoRemoteToDataMapper()

    @Provides
    @Singleton
    fun provideCardInfoRemote(
        cardInfoService: CardInfoService,
        cardInfoRemoteToDataMapper: CardInfoRemoteToDataMapper,
    ): CardInfoRemote = CardInfoRemoteImpl(
        cardInfoService,
        cardInfoRemoteToDataMapper,
    )
}