package ru.test.sample.cardbininfotracker.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.test.sample.cardbininfotracker.presentation.model.CardInfoPresentationModel

@Composable
fun CardInfoItem(cardInfo: CardInfoPresentationModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Схема карты: ${cardInfo.scheme}")
        Text(text = "Тип карты: ${cardInfo.type}")
        Text(text = "Бренд карты: ${cardInfo.brand}")
        Text(text = "Банк: ${cardInfo.bankPresentationModel.name}")
        Text(text = "URL банка: ${cardInfo.bankPresentationModel.url}")
        Text(text = "Страна: ${cardInfo.countryPresentationModel.name}")
        Text(text = "Город банка: ${cardInfo.bankPresentationModel.city}")
        Text(text = "Телефон банка: ${cardInfo.bankPresentationModel.phone}")
        Text(text = "Широта: ${cardInfo.countryPresentationModel.latitude}")
        Text(text = "Долгота: ${cardInfo.countryPresentationModel.longitude}")
    }
}