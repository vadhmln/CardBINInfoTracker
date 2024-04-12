package ru.test.sample.database.mapper

import ru.test.sample.data.model.CardInfoDataModel
import ru.test.sample.database.entity.BankEntity
import ru.test.sample.database.entity.CardInfoEntity
import ru.test.sample.database.entity.CardNumberEntity
import ru.test.sample.database.entity.CountryEntity

class CardInfoDataToDatabaseMapper {

    fun toDatabase(input: CardInfoDataModel) =
        CardInfoEntity(
            number = CardNumberEntity(
                length = input.number.length,
                luhn = input.number.luhn,
            ),
            scheme = input.scheme,
            type = input.type,
            brand = input.brand,
            country = CountryEntity(
                numeric = input.countryDataModel.numeric,
                alpha2 = input.countryDataModel.alpha2,
                countryName = input.countryDataModel.name,
                emoji = input.countryDataModel.emoji,
                currency = input.countryDataModel.currency,
                latitude = input.countryDataModel.latitude,
                longitude = input.countryDataModel.longitude,
            ),
            bank = BankEntity(
                bankName = input.bankDataModel.name,
                url = input.bankDataModel.url,
                phone = input.bankDataModel.phone,
                city = input.bankDataModel.city,
            ),
        )
}