package ru.test.sample.domain.usecase

import ru.test.sample.domain.repository.CardInfoRepository

class GetAllCardsUseCase(private val cardInfoRepository: CardInfoRepository) {

    fun execute() = cardInfoRepository.getAllCards()
}