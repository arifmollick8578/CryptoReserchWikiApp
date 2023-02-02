package com.mollick.cryptocurrencywikiapp.data.remote

import com.mollick.cryptocurrencywikiapp.data.remote.dto.CoinDetailDto
import com.mollick.cryptocurrencywikiapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}
