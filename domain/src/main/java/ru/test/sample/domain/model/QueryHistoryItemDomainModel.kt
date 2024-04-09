package ru.test.sample.domain.model

data class QueryHistoryItemDomainModel(
    val bin: String,
    val timestamp: Long,
    val binInfoDomainModel: BinInfoDomainModel
)
