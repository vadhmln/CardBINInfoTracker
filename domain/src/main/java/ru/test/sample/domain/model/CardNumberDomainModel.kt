package ru.test.sample.domain.model

data class CardNumberDomainModel(
    val length: Int,
    val luhn: Boolean
)