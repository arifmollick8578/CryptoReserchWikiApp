package com.mollick.cryptocurrencywikiapp.presentation.coin_details

import com.mollick.cryptocurrencywikiapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String? = null
)
