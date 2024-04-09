package ru.test.sample.data.datasource

import ru.test.sample.data.model.CardInfoDataModel

interface BinDataSource {
    fun getBinInfo(bin: String): Result<CardInfoDataModel>
}