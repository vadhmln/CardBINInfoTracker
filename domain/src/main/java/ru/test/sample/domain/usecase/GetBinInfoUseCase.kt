package ru.test.sample.domain.usecase

import ru.test.sample.domain.model.BinInfo
import ru.test.sample.domain.repository.BinInfoRepository

class GetBinInfoUseCase(private val binInfoRepository: BinInfoRepository) {
    suspend fun execute(bin: String): Result<BinInfo> {
        return binInfoRepository.getBinInfo(bin)
    }
}
