package ru.test.sample.cardbininfotracker.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.test.sample.cardbininfotracker.presentation.mapper.CardInfoDomainToPresentationMapper
import ru.test.sample.cardbininfotracker.presentation.model.CardInfoPresentationModel
import ru.test.sample.domain.usecase.GetAllCardsUseCase
import ru.test.sample.domain.usecase.GetCardInfoUseCase
import javax.inject.Inject

@HiltViewModel
class CardInfoViewModel @Inject constructor(
    private val getCardInfoUseCase: GetCardInfoUseCase,
    private val getAllCardsUseCase: GetAllCardsUseCase,
    private val cardInfoDomainToPresentationMapper: CardInfoDomainToPresentationMapper,
): ViewModel() {

    private var _bin = mutableStateOf("")
    val bin: State<String> get() = _bin

    private var _cardInfo = mutableStateOf<CardInfoPresentationModel?>(null)
    val cardInfo: State<CardInfoPresentationModel?> get() = _cardInfo

    private val _cardInfoList = getAllCardsUseCase.execute().asLiveData().map {list ->
        list.map(cardInfoDomainToPresentationMapper::toPresentation)
    }
    val cardInfoList: LiveData<List<CardInfoPresentationModel>> get() = _cardInfoList

    fun getCardInfo(bin: String) {
        viewModelScope.launch {
            getCardInfoUseCase.execute(bin)
                .map(cardInfoDomainToPresentationMapper::toPresentation)
                .collect { result ->
                    Log.d("result", result.scheme)
                    _cardInfo.value = result
                }
        }
    }

    fun onBinChanged(newBin: String) {
        _bin.value = newBin
    }
}

