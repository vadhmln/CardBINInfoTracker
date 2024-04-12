package ru.test.sample.cardbininfotracker.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import ru.test.sample.cardbininfotracker.presentation.CardInfoViewModel

@Composable
fun CardInfoScreen(
    viewModel: CardInfoViewModel,
    navController: NavHostController
) {
    val bin by viewModel.bin
    val cardInfo by viewModel.cardInfo
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = bin,
            onValueChange = { viewModel.onBinChanged(it) },
            label = { Text("Введите 8 цифр карты") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { scope.launch { viewModel.getCardInfo(bin) } }) {
            Text("Получить информацию")
        }

        cardInfo?.let { info ->
            Text("Схема карты: ${info.scheme}")
            Text("Тип карты: ${info.type}")
            Text("Бренд карты: ${info.brand}")
            Text("Банк: ${info.bankPresentationModel.name}")
            Text("URL банка: ${info.bankPresentationModel.url}")
            Text("Страна: ${info.countryPresentationModel.name}")
            Text("Город банка: ${info.bankPresentationModel.city}")
            Text("Телефон банка: ${info.bankPresentationModel.phone}")
            Text("Широта: ${info.countryPresentationModel.latitude}")
            Text("Долгота: ${info.countryPresentationModel.longitude}")
        }

        Button(onClick = { navController.navigate("cardListScreen") }) {
            Text("Перейти к списку карт")
        }
    }
}
