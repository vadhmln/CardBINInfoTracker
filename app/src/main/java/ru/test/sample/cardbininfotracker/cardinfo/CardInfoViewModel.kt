package ru.test.sample.cardbininfotracker.cardinfo

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import ru.test.sample.cardbininfotracker.mapper.CardInfoDomainToPresentationMapper
import ru.test.sample.cardbininfotracker.model.CardInfoPresentationModel
import ru.test.sample.domain.usecase.GetAllCardsUseCase
import ru.test.sample.domain.usecase.GetCardInfoUseCase
import javax.inject.Inject

@HiltViewModel
class CardInfoViewModel @Inject constructor(
    private val getCardInfoUseCase: GetCardInfoUseCase,
    private val getAllCardsUseCase: GetAllCardsUseCase,
    private val cardInfoDomainToPresentationMapper: CardInfoDomainToPresentationMapper,
): ViewModel() {

    var bin = mutableStateOf("")
        private set

    // Добавляем состояние для информации о карте
    var cardInfo = mutableStateOf<CardInfoPresentationModel?>(null)
        private set

    val cardInfoList = getAllCardsUseCase.execute().asLiveData().map {list ->
        list.map(cardInfoDomainToPresentationMapper::toPresentation)
    }

    suspend fun getCardInfo(bin: String) {
        getCardInfoUseCase.execute(bin)
            .map(cardInfoDomainToPresentationMapper::toPresentation)
            .collect { result ->
                Log.d("result", result.scheme)
                // Обновляем состояние с полученной информацией
                cardInfo.value = result
            }
    }

    fun onBinChanged(newBin: String) {
        bin.value = newBin
    }
}
