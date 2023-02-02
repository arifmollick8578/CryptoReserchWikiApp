package com.mollick.cryptocurrencywikiapp.domain.use_cases.get_coins

import com.mollick.cryptocurrencywikiapp.common.Resource
import com.mollick.cryptocurrencywikiapp.data.remote.dto.toCoin
import com.mollick.cryptocurrencywikiapp.domain.model.Coin
import com.mollick.cryptocurrencywikiapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (exception: HttpException) {
            emit(Resource.Error<List<Coin>>(message = exception.localizedMessage ?: "An unexpected error."))
        } catch (exception: IOException) {
            emit(Resource.Error<List<Coin>>(message = "Couldn't reach server. Check your internet connection."))
        }
    }
}
