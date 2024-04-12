package ru.test.sample.database.mapper

import ru.test.sample.data.model.BankDataModel
import ru.test.sample.data.model.CardInfoDataModel
import ru.test.sample.data.model.CardNumberDataModel
import ru.test.sample.data.model.CountryDataModel
import ru.test.sample.database.entity.CardInfoEntity

class CardInfoDatabaseToDataMapper {

    fun toData(input: CardInfoEntity) =
        CardInfoDataModel(
            number = CardNumberDataModel(
                length = input.number.length,
                luhn = input.number.luhn,
            ),
            scheme = input.scheme,
            type = input.type,
            brand = input.brand,
            countryDataModel = CountryDataModel(
                numeric = input.country.numeric,
                alpha2 = input.country.alpha2,
                name = input.country.countryName,
                emoji = input.country.emoji,
                currency = input.country.currency,
                latitude = input.country.latitude,
                longitude = input.country.longitude,
            ),
            bankDataModel = BankDataModel(
                name = input.bank.bankName,
                url = input.bank.url,
                phone = input.bank.phone,
                city = input.bank.city,
            ),
        )
}