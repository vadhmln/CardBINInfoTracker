package ru.test.sample.data.model

data class CardInfoDataModel(
    val number: CardNumberDataModel,
    val scheme: String = "",
    val type: String = "",
    val brand: String = "",
    val countryDataModel: CountryDataModel,
    val bankDataModel: BankDataModel
)