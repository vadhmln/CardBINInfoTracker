package ru.test.sample.database.entity

data class CountryEntity(
    val numeric: String = "",
    val alpha2: String = "",
    val countryName: String = "",
    val emoji: String = "",
    val currency: String = "",
    val latitude: Int = 0,
    val longitude: Int = 0,
)