package ru.test.sample.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CardInfoResponse(
    val number: CardNumberResponse = CardNumberResponse(),
    val scheme: String = "",
    val type: String = "",
    val brand: String = "",
    val country: CountryResponse = CountryResponse(),
    val bank: BankResponse = BankResponse(),
)