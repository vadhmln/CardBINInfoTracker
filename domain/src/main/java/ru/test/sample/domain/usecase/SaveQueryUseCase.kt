package ru.test.sample.domain.usecase

import ru.test.sample.domain.model.QueryHistoryItemDomainModel
import ru.test.sample.domain.repository.QueryHistoryRepository

class SaveQueryUseCase(private val queryHistoryRepository: QueryHistoryRepository) {
    suspend fun execute(queryHistoryItemDomainModel: QueryHistoryItemDomainModel): Result<Unit> {
        return queryHistoryRepository.saveQuery(queryHistoryItemDomainModel)
    }
}
