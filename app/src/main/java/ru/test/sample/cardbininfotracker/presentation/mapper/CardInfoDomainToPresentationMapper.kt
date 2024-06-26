package ru.test.sample.cardbininfotracker.presentation.mapper

import ru.test.sample.cardbininfotracker.presentation.model.BankPresentationModel
import ru.test.sample.cardbininfotracker.presentation.model.CardInfoPresentationModel
import ru.test.sample.cardbininfotracker.presentation.model.CardNumberPresentationModel
import ru.test.sample.cardbininfotracker.presentation.model.CountryPresentationModel
import ru.test.sample.domain.model.CardInfoDomainModel

class CardInfoDomainToPresentationMapper {

    fun toPresentation(input: CardInfoDomainModel) =
        CardInfoPresentationModel(
            number = CardNumberPresentationModel(
                length = input.number.length,
                luhn = input.number.luhn,
            ),
            scheme = input.scheme,
            type = input.type,
            brand = input.brand,
            countryPresentationModel = CountryPresentationModel(
                numeric = input.countryDomainModel.numeric,
                alpha2 = input.countryDomainModel.alpha2,
                name = input.countryDomainModel.name,
                emoji = input.countryDomainModel.emoji,
                currency = input.countryDomainModel.currency,
                latitude = input.countryDomainModel.latitude,
                longitude = input.countryDomainModel.longitude,
            ),
            bankPresentationModel = BankPresentationModel(
                name = input.bankDomainModel.name,
                url = input.bankDomainModel.url,
                phone = input.bankDomainModel.phone,
                city = input.bankDomainModel.city,
            ),
        )
}