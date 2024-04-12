package ru.test.sample.cardbininfotracker.presentation.model

data class CardInfoPresentationModel(
    val number: CardNumberPresentationModel,
    val scheme: String = "",
    val type: String = "",
    val brand: String = "",
    val countryPresentationModel: CountryPresentationModel,
    val bankPresentationModel: BankPresentationModel
)