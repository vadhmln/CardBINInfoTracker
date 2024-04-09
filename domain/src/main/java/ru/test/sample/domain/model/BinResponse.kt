package ru.test.sample.domain.model

data class BinResponse(
    val number: CardNumber,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: Country,
    val bank: Bank
)