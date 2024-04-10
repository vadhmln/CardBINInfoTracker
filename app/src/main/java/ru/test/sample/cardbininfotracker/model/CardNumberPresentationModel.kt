package ru.test.sample.cardbininfotracker.model

data class CardNumberPresentationModel(
    val length: Int = 0,
    val luhn: Boolean = false
)