package com.mollick.cryptocurrencywikiapp.presentation.coin_list

import com.mollick.cryptocurrencywikiapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String? = null
)
