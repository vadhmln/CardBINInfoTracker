package ru.test.sample.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CardInfoResponse(
    val number: CardNumberResponse,
    val scheme: String = "",
    val type: String = "",
    val brand: String = "",
    val countryDomainModel: CountryResponse,
    val bankDomainModel: BankResponse
)