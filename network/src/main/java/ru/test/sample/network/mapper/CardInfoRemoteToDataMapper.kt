package ru.test.sample.network.mapper

import ru.test.sample.data.model.BankDataModel
import ru.test.sample.data.model.CardInfoDataModel
import ru.test.sample.data.model.CardNumberDataModel
import ru.test.sample.data.model.CountryDataModel
import ru.test.sample.network.model.CardInfoResponse

class CardInfoRemoteToDataMapper {

    fun toData(input: CardInfoResponse) =
        CardInfoDataModel(
            number = CardNumberDataModel(
                length = input.number.length,
                luhn = input.number.luhn,
            ),
            scheme = input.scheme,
            type = input.type,
            brand = input.brand,
            countryDataModel = CountryDataModel(
                numeric = input.countryResponse.numeric,
                alpha2 = input.countryResponse.alpha2,
                name = input.countryResponse.name,
                emoji = input.countryResponse.emoji,
                currency = input.countryResponse.currency,
                latitude = input.countryResponse.latitude,
                longitude = input.countryResponse.longitude,
            ),
            bankDataModel = BankDataModel(
                name = input.bankResponse.name,
                url = input.bankResponse.url,
                phone = input.bankResponse.phone,
                city = input.bankResponse.city,
            ),
        )
}