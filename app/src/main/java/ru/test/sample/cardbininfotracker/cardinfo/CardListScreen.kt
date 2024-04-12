package ru.test.sample.cardbininfotracker.cardinfo

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardListScreen(viewModel: CardInfoViewModel) {

    val cardInfoList by viewModel.cardInfoList.observeAsState(initial = emptyList())

    LazyColumn {
        itemsIndexed(cardInfoList) { index, cardInfo ->
            Text(
                text = "Карта номер ${index + 1}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
            CardInfoItem(cardInfo)
            HorizontalDivider(thickness = 1.dp, color = Color.Gray)
        }
    }
}