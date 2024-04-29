package com.mokshith.mvvmclean.presentation.theme.coinList

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mokshith.mvvmclean.common.ApiState
import com.mokshith.mvvmclean.domain.useCase.getCoins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private var getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    //changes the orientation r changes the language
    // less business logic

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is ApiState.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }

                is ApiState.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }

                is ApiState.Error -> {
                    _state.value =
                        CoinListState(error = result.message ?: "An Unexpected error occurred")
                }
                else -> {
                    Log.e("TAG", "getCoins: error case", )
                }
            }
        }.launchIn(viewModelScope)
    }
}