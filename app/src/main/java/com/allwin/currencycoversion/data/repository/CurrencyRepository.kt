package com.allwin.currencycoversion.data.repository

import com.allwin.currencycoversion.data.model.currency.CurrencyResponse
import com.allwin.currencycoversion.data.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
     suspend fun getCurrencies(): Flow<NetworkResult<CurrencyResponse>>
     suspend fun getAllCurrencies(): List<String>
     suspend fun getExchangeRate(currencyCode: String): Double
}