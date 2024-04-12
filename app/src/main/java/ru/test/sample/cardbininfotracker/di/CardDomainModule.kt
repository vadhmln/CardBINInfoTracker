package ru.test.sample.cardbininfotracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.test.sample.domain.repository.CardInfoRepository
import ru.test.sample.domain.usecase.GetAllCardsUseCase
import ru.test.sample.domain.usecase.GetCardInfoUseCase

@Module
@InstallIn(ViewModelComponent::class)
class CardDomainModule {

    @Provides
    fun provideGetCardInfoUseCase(cardInfoRepository: CardInfoRepository) =
        GetCardInfoUseCase(cardInfoRepository)

    @Provides
    fun provideGetAllCardsUseCase(cardInfoRepository: CardInfoRepository) =
        GetAllCardsUseCase(cardInfoRepository)
}