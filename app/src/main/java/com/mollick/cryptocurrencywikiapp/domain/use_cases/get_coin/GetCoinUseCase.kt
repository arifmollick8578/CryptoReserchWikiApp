package com.mollick.cryptocurrencywikiapp.domain.use_cases.get_coin

import com.mollick.cryptocurrencywikiapp.common.Resource
import com.mollick.cryptocurrencywikiapp.data.remote.dto.toCoinDetail
import com.mollick.cryptocurrencywikiapp.domain.model.CoinDetail
import com.mollick.cryptocurrencywikiapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(id: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(id).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (exception: HttpException) {
            emit(Resource.Error<CoinDetail>(message = exception.localizedMessage ?: "An unexpected error."))
        } catch (exception: IOException) {
            emit(Resource.Error<CoinDetail>(message = "Couldn't reach server. Check your internet connection."))
        }
    }
}
