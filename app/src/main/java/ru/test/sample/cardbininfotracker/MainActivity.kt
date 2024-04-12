package ru.test.sample.cardbininfotracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import ru.test.sample.cardbininfotracker.presentation.CardInfoViewModel
import ru.test.sample.cardbininfotracker.navigation.AppNavigator
import ru.test.sample.cardbininfotracker.ui.theme.CardBINInfoTrackerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val cardInfoViewModel: CardInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardBINInfoTrackerTheme {
                AppNavigator(viewModel = cardInfoViewModel)
            }
        }
    }
}
