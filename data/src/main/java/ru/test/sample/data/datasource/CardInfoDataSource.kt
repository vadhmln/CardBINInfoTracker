package ru.test.sample.data.datasource

import ru.test.sample.data.model.CardInfoDataModel

interface CardInfoDataSource {
    fun getBinInfo(bin: String): Result<CardInfoDataModel>
}