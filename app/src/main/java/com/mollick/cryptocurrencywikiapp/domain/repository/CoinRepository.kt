package com.mollick.cryptocurrencywikiapp.domain.repository

import com.mollick.cryptocurrencywikiapp.data.remote.dto.CoinDetailDto
import com.mollick.cryptocurrencywikiapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoin(): List<CoinDto>

    suspend fun getCoinById(id: String): CoinDetailDto
}
