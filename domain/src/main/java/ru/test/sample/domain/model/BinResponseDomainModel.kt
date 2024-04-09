package ru.test.sample.domain.model

data class BinResponseDomainModel(
    val number: CardNumberDomainModel,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val countryDomainModel: CountryDomainModel,
    val bankDomainModel: BankDomainModel
)