package ru.test.sample.data.mapper

import ru.test.sample.data.model.CardInfoDataModel
import ru.test.sample.domain.model.BankDomainModel
import ru.test.sample.domain.model.CardInfoDomainModel
import ru.test.sample.domain.model.CardNumberDomainModel
import ru.test.sample.domain.model.CountryDomainModel

class CardInfoDataToDomainMapper {

    fun toDomain(input: CardInfoDataModel) =
        CardInfoDomainModel(
            number = CardNumberDomainModel(
                length = input.number.length,
                luhn = input.number.luhn,
            ),
            scheme = input.scheme,
            type = input.type,
            brand = input.brand,
            countryDomainModel = CountryDomainModel(
                numeric = input.countryDataModel.numeric,
                alpha2 = input.countryDataModel.alpha2,
                name = input.countryDataModel.name,
                emoji = input.countryDataModel.emoji,
                currency = input.countryDataModel.currency,
                latitude = input.countryDataModel.latitude,
                longitude = input.countryDataModel.longitude,
            ),
            bankDomainModel = BankDomainModel(
                name = input.bankDataModel.name,
                url = input.bankDataModel.url,
                phone = input.bankDataModel.phone,
                city = input.bankDataModel.city,
            ),
        )
}