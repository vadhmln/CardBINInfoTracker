package ru.test.sample.cardbininfotracker.model

data class CardInfoPresentationModel(
    val number: CardNumberPresentationModel,
    val scheme: String = "",
    val type: String = "",
    val brand: String = "",
    val countryDomainModel: CountryPresentationModel,
    val bankDomainModel: BankPresentationModel
)