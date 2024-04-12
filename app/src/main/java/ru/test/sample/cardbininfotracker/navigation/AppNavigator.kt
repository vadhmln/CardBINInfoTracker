package ru.test.sample.cardbininfotracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.test.sample.cardbininfotracker.ui.view.CardInfoScreen
import ru.test.sample.cardbininfotracker.presentation.CardInfoViewModel
import ru.test.sample.cardbininfotracker.ui.view.CardListScreen

@Composable
fun AppNavigator(viewModel: CardInfoViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "cardInfoScreen") {
        composable("cardInfoScreen") {
            CardInfoScreen(viewModel, navController)
        }
        composable("cardListScreen") {
            CardListScreen(viewModel)
        }
    }
}