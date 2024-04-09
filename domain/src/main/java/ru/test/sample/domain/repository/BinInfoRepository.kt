package ru.test.sample.domain.repository

import ru.test.sample.domain.model.BinInfoDomainModel

interface BinInfoRepository {
    fun getBinInfo(bin: String): Result<BinInfoDomainModel>
}