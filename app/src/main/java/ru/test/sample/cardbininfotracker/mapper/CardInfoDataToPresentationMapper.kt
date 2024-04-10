package ru.test.sample.cardbininfotracker.mapper

import ru.test.sample.cardbininfotracker.model.BankPresentationModel
import ru.test.sample.cardbininfotracker.model.CardInfoPresentationModel
import ru.test.sample.cardbininfotracker.model.CardNumberPresentationModel
import ru.test.sample.cardbininfotracker.model.CountryPresentationModel
import ru.test.sample.data.model.CardInfoDataModel

class CardInfoDataToPresentationMapper {

    fun toPresentation(input: CardInfoDataModel) =
        CardInfoPresentationModel(
            number = CardNumberPresentationModel(
                length = input.number.length,
                luhn = input.number.luhn,
            ),
            scheme = input.scheme,
            type = input.type,
            brand = input.brand,
            countryDomainModel = CountryPresentationModel(
                numeric = input.countryDomainModel.numeric,
                alpha2 = input.countryDomainModel.alpha2,
                name = input.countryDomainModel.name,
                emoji = input.countryDomainModel.emoji,
                currency = input.countryDomainModel.currency,
                latitude = input.countryDomainModel.latitude,
                longitude = input.countryDomainModel.longitude,
            ),
            bankDomainModel = BankPresentationModel(
                name = input.bankDomainModel.name,
                url = input.bankDomainModel.url,
                phone = input.bankDomainModel.phone,
                city = input.bankDomainModel.city,
            ),
        )
}