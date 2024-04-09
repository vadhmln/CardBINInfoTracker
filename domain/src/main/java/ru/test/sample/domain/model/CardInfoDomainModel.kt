package ru.test.sample.domain.model

data class CardInfoDomainModel(
    val number: CardNumberDomainModel,
    val scheme: String = "",
    val type: String = "",
    val brand: String = "",
    val countryDomainModel: CountryDomainModel,
    val bankDomainModel: BankDomainModel
)