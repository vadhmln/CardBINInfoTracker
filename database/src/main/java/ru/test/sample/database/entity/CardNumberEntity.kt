package ru.test.sample.database.entity

data class CardNumberEntity(
    val length: Int = 0,
    val luhn: Boolean = false
)