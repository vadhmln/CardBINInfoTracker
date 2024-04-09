package ru.test.sample.domain.repository

import ru.test.sample.domain.model.BinInfo

interface BinInfoRepository {
    fun getBinInfo(bin: String): Result<BinInfo>
}