package ru.test.sample.domain.model

data class CardNumberDomainModel(
    val length: Int = 0,
    val luhn: Boolean = false
)