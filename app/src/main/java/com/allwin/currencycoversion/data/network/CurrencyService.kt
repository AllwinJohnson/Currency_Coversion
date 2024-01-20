package com.allwin.currencycoversion.data.network

import com.allwin.currencycoversion.data.model.currency.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyService {

    @GET("latest.json")
    suspend fun getCurrencies(
    ): Response<CurrencyResponse>

}