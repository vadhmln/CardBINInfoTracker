package ru.test.sample.domain.repository

import ru.test.sample.domain.model.QueryHistoryItem

interface QueryHistoryRepository {
    fun getQueryHistory(): Result<List<QueryHistoryItem>>

    fun saveQuery(queryHistoryItem: QueryHistoryItem): Result<Unit>
}