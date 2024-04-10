package ru.test.sample.cardbininfotracker.model

data class QueryHistoryItemPresentationModel(
    val bin: String = "",
    val timestamp: Long = 0L,
    val binInfoDomainModel: CardInfoPresentationModel,
)
