package ru.test.sample.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CardNumberResponse(
    val length: Int = 0,
    val luhn: Boolean = false
)