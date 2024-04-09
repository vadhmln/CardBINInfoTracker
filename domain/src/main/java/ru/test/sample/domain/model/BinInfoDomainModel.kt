package ru.test.sample.domain.model

data class BinInfoDomainModel(
    val bin: String,
    val cardNumberLength: Int,
    val isLuhn: Boolean,
    val scheme: String,
    val type: String,
    val brand: String,
    val isPrepaid: Boolean,
    val countryNumeric: String,
    val countryAlpha2: String,
    val countryName: String,
    val countryEmoji: String,
    val countryCurrency: String,
    val countryLatitude: Int,
    val countryLongitude: Int,
    val bankName: String,
    val bankUrl: String,
    val bankPhone: String,
    val bankCity: String
)
