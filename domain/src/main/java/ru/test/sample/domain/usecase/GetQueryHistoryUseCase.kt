package ru.test.sample.domain.usecase

import ru.test.sample.domain.model.QueryHistoryItemDomainModel
import ru.test.sample.domain.repository.QueryHistoryRepository

class GetQueryHistoryUseCase(private val queryHistoryRepository: QueryHistoryRepository) {
    suspend fun execute(): Result<List<QueryHistoryItemDomainModel>> {
        return queryHistoryRepository.getQueryHistory()
    }
}
