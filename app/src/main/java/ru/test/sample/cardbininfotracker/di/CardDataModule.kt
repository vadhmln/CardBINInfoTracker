package ru.test.sample.cardbininfotracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.test.sample.cardbininfotracker.mapper.CardInfoDomainToPresentationMapper
import ru.test.sample.data.datasource.CardInfoLocal
import ru.test.sample.data.datasource.CardInfoRemote
import ru.test.sample.data.mapper.CardInfoDataToDomainMapper
import ru.test.sample.data.mapper.CardInfoDomainToDataMapper
import ru.test.sample.data.repository.CardInfoRepositoryImpl
import ru.test.sample.domain.repository.CardInfoRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CardDataModule {

    @Provides
    fun provideCardInfoDataToDomainMapper() = CardInfoDataToDomainMapper()

    @Provides
    fun provideCardInfoDomainToDataMapper() = CardInfoDomainToDataMapper()

    @Provides
    fun provideCardInfoDomainToPresentationMapper() = CardInfoDomainToPresentationMapper()

    @Provides
    @Singleton
    fun provideCardInfoRepository(
        dataSource: CardInfoRemote,
        cardInfoLocal: CardInfoLocal,
        cardInfoDataToDomainMapper: CardInfoDataToDomainMapper,
        cardInfoDomainToDataMapper: CardInfoDomainToDataMapper,
    ): CardInfoRepository = CardInfoRepositoryImpl(
        dataSource,
        cardInfoLocal,
        cardInfoDataToDomainMapper,
        cardInfoDomainToDataMapper,
    )
}