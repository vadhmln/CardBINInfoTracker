package ru.test.sample.domain.model

data class QueryHistoryItem(
    val bin: String,
    val timestamp: Long,
    val binInfo: BinInfo
)
