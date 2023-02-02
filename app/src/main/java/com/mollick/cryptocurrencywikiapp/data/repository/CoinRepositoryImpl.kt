package com.mollick.cryptocurrencywikiapp.data.repository

import com.mollick.cryptocurrencywikiapp.data.remote.CoinPaprikaApi
import com.mollick.cryptocurrencywikiapp.data.remote.dto.CoinDetailDto
import com.mollick.cryptocurrencywikiapp.data.remote.dto.CoinDto
import com.mollick.cryptocurrencywikiapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
        return api.getCoinById(id)
    }
}
