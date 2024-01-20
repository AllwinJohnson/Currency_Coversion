package com.allwin.currencycoversion.data.network.dataSource

import com.allwin.currencycoversion.data.network.CurrencyService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val currencyService: CurrencyService,
) {
    suspend fun getCurrencies() = currencyService.getCurrencies()

}