package com.allwin.currencycoversion.repository

import com.allwin.currencycoversion.data.model.currency.CurrencyResponse
import com.allwin.currencycoversion.data.network.NetworkResult
import com.allwin.currencycoversion.data.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


open class StubCurrencyRepositoryImpl @Inject constructor() : CurrencyRepository {
    override suspend fun getCurrencies(): Flow<NetworkResult<CurrencyResponse>> {
        val mockCurrencyResponse = CurrencyResponse()
        return flow {
            emit(NetworkResult.Success(mockCurrencyResponse))
        }
    }

    override suspend fun getAllCurrencies(): List<String> {
        return listOf(
            "USD",
            "EUR",
            "GBP",
        )
    }

    override suspend fun getExchangeRate(currencyCode: String): Double {
        return 53.3
    }
}