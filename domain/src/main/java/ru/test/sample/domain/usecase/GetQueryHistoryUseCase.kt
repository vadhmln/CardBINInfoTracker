package ru.test.sample.domain.usecase

import ru.test.sample.domain.model.QueryHistoryItem
import ru.test.sample.domain.repository.QueryHistoryRepository

class GetQueryHistoryUseCase(private val queryHistoryRepository: QueryHistoryRepository) {
    suspend fun execute(): Result<List<QueryHistoryItem>> {
        return queryHistoryRepository.getQueryHistory()
    }
}
