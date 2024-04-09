package ru.test.sample.domain.usecase

import ru.test.sample.domain.model.QueryHistoryItem
import ru.test.sample.domain.repository.QueryHistoryRepository

class SaveQueryUseCase(private val queryHistoryRepository: QueryHistoryRepository) {
    suspend fun execute(queryHistoryItem: QueryHistoryItem): Result<Unit> {
        return queryHistoryRepository.saveQuery(queryHistoryItem)
    }
}
