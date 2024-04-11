package ru.test.sample.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CardNumberResponse(
    val length: Int = 10,
    val luhn: Boolean = true
)