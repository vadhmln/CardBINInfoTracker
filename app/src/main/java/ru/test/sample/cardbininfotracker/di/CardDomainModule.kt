package ru.test.sample.cardbininfotracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.test.sample.domain.repository.CardInfoRepository
import ru.test.sample.domain.repository.QueryHistoryRepository
import ru.test.sample.domain.usecase.GetCardInfoUseCase
import ru.test.sample.domain.usecase.SaveQueryUseCase

@Module
@InstallIn(ViewModelComponent::class)
class CardDomainModule {

    @Provides
    fun provideGetCardInfoUseCase(cardInfoRepository: CardInfoRepository) =
        GetCardInfoUseCase(cardInfoRepository)

    @Provides
    fun provideSaveQueryUseCase(queryHistoryRepository: QueryHistoryRepository) =
        SaveQueryUseCase(queryHistoryRepository)
}