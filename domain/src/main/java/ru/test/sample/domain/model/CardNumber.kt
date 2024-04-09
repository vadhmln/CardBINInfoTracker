package ru.test.sample.domain.model

data class CardNumber(
    val length: Int,
    val luhn: Boolean
)