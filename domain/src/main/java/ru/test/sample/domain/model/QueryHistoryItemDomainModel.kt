package ru.test.sample.domain.model

data class QueryHistoryItemDomainModel(
    val bin: String = "",
    val timestamp: Long = 0L,
    val binInfoDomainModel: CardInfoDomainModel,
)
