package ru.test.sample.cardbininfotracker.mapper

import ru.test.sample.cardbininfotracker.model.CardInfoPresentationModel
import ru.test.sample.data.model.BankDataModel
import ru.test.sample.data.model.CardInfoDataModel
import ru.test.sample.data.model.CardNumberDataModel
import ru.test.sample.data.model.CountryDataModel

class CardInfoPresentationToDataMapper {

    fun toData(input: CardInfoPresentationModel) =
        CardInfoDataModel(
            number = CardNumberDataModel(
                length = input.number.length,
                luhn = input.number.luhn,
            ),
            scheme = input.scheme,
            type = input.type,
            brand = input.brand,
            countryDomainModel = CountryDataModel(
                numeric = input.countryDomainModel.numeric,
                alpha2 = input.countryDomainModel.alpha2,
                name = input.countryDomainModel.name,
                emoji = input.countryDomainModel.emoji,
                currency = input.countryDomainModel.currency,
                latitude = input.countryDomainModel.latitude,
                longitude = input.countryDomainModel.longitude,
            ),
            bankDomainModel = BankDataModel(
                name = input.bankDomainModel.name,
                url = input.bankDomainModel.url,
                phone = input.bankDomainModel.phone,
                city = input.bankDomainModel.city,
            ),
        )
}