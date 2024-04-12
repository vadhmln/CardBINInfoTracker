package ru.test.sample.cardbininfotracker.presentation.model

data class CountryPresentationModel(
    val numeric: String = "",
    val alpha2: String = "",
    val name: String = "",
    val emoji: String = "",
    val currency: String = "",
    val latitude: Int = 0,
    val longitude: Int = 0,
)