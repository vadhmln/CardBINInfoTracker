package ru.test.sample.data.model

data class QueryHistoryItemDataModel(
    val bin: String = "",
    val timestamp: Long = 0L,
    val binInfoDomainModel: CardInfoDataModel,
)
