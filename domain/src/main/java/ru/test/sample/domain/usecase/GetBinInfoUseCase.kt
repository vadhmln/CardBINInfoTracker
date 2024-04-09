package ru.test.sample.domain.usecase

import ru.test.sample.domain.model.BinInfoDomainModel
import ru.test.sample.domain.repository.BinInfoRepository

class GetBinInfoUseCase(private val binInfoRepository: BinInfoRepository) {
    suspend fun execute(bin: String): Result<BinInfoDomainModel> {
        return binInfoRepository.getBinInfo(bin)
    }
}
