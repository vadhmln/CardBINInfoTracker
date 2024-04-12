package ru.test.sample.cardbininfotracker.presentation.mapper

import ru.test.sample.cardbininfotracker.presentation.model.CardInfoPresentationModel
import ru.test.sample.domain.model.BankDomainModel
import ru.test.sample.domain.model.CardInfoDomainModel
import ru.test.sample.domain.model.CardNumberDomainModel
import ru.test.sample.domain.model.CountryDomainModel

class CardInfoPresentationToDomainMapper {

    fun toDomain(input: CardInfoPresentationModel) =
        CardInfoDomainModel(
            number = CardNumberDomainModel(
                length = input.number.length,
                luhn = input.number.luhn,
            ),
            scheme = input.scheme,
            type = input.type,
            brand = input.brand,
            countryDomainModel = CountryDomainModel(
                numeric = input.countryPresentationModel.numeric,
                alpha2 = input.countryPresentationModel.alpha2,
                name = input.countryPresentationModel.name,
                emoji = input.countryPresentationModel.emoji,
                currency = input.countryPresentationModel.currency,
                latitude = input.countryPresentationModel.latitude,
                longitude = input.countryPresentationModel.longitude,
            ),
            bankDomainModel = BankDomainModel(
                name = input.bankPresentationModel.name,
                url = input.bankPresentationModel.url,
                phone = input.bankPresentationModel.phone,
                city = input.bankPresentationModel.city,
            ),
        )
}