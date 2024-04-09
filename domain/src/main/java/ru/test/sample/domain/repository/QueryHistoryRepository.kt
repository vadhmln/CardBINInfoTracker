package ru.test.sample.domain.repository

import ru.test.sample.domain.model.QueryHistoryItemDomainModel

interface QueryHistoryRepository {
    fun getQueryHistory(): Result<List<QueryHistoryItemDomainModel>>

    fun saveQuery(queryHistoryItemDomainModel: QueryHistoryItemDomainModel): Result<Unit>
}