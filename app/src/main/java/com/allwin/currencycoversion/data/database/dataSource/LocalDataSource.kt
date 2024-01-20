package com.allwin.currencycoversion.data.database.dataSource

import com.allwin.currencycoversion.data.database.currency.CurrencyDao
import com.allwin.currencycoversion.data.database.currency.CurrencyEntity
import com.allwin.currencycoversion.data.network.CurrencyService
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val currencyDao: CurrencyDao
) {

    suspend fun insertCurrencies(currencyEntities: List<CurrencyEntity>) =
        currencyDao.insertCurrencies(currencyEntities)

    suspend fun getAllCurrencies() = currencyDao.getAllCurrencies()

    suspend fun getExchangeRate(currencyCode : String) = currencyDao.getExchangeRate(currencyCode)

}