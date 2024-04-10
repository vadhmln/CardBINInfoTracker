package ru.test.sample.domain.usecase

import ru.test.sample.domain.model.CardInfoDomainModel
import ru.test.sample.domain.repository.CardInfoRepository

class GetCardInfoUseCase(private val cardInfoRepository: CardInfoRepository) {
    suspend fun execute(bin: String): Result<CardInfoDomainModel> {
        return cardInfoRepository.getBinInfo(bin)
    }
}
