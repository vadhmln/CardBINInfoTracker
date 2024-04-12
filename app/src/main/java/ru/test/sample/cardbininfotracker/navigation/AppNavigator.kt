package ru.test.sample.cardbininfotracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.test.sample.cardbininfotracker.cardinfo.CardInfoScreen
import ru.test.sample.cardbininfotracker.cardinfo.CardInfoViewModel
import ru.test.sample.cardbininfotracker.cardinfo.CardListScreen

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