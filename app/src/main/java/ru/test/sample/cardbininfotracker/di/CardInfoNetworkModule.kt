package ru.test.sample.cardbininfotracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.test.sample.data.datasource.CardInfoRemote
import ru.test.sample.network.CardInfoRemoteImpl
import ru.test.sample.network.CardInfoService
import ru.test.sample.network.mapper.CardInfoRemoteToDataMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CardInfoNetworkModule {

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