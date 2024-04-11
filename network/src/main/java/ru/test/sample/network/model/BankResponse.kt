package ru.test.sample.network.model

import kotlinx.serialization.Serializable

@Serializable
data class BankResponse(
    val name: String = "",
    val url: String = "",
    val phone: String = "",
    val city: String = "",
)