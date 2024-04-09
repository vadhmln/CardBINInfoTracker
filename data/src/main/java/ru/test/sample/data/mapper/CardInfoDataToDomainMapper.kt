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
                numeric = input.countryDomainModel.numeric,
                alpha2 = input.countryDomainModel.alpha2,
                name = input.countryDomainModel.name,
                emoji = input.countryDomainModel.emoji,
                currency = input.countryDomainModel.currency,
                latitude = input.countryDomainModel.latitude,
                longitude = input.countryDomainModel.longitude,
            ),
            bankDomainModel = BankDomainModel(
                name = input.bankDomainModel.name,
                url = input.bankDomainModel.url,
                phone = input.bankDomainModel.phone,
                city = input.bankDomainModel.city,
            ),
        )
}