package ru.test.sample.cardbininfotracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.test.sample.data.datasource.CardInfoDataSource
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
    @Singleton
    fun provideCardInfoRepository(
        dataSource: CardInfoDataSource,
        cardInfoDataToDomainMapper: CardInfoDataToDomainMapper,
    ): CardInfoRepository = CardInfoRepositoryImpl(
        dataSource,
        cardInfoDataToDomainMapper,
    )
}