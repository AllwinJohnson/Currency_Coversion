package com.allwin.currencycoversion.data.database.currency

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.allwin.currencycoversion.data.database.DBConstants

@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencies(currencyList: List<CurrencyEntity>)

    @Query("SELECT currency_code FROM ${DBConstants.CURRENCY_TABLE}")
    suspend fun getAllCurrencies(): List<String>

    @Query("SELECT exchange_rate FROM ${DBConstants.CURRENCY_TABLE} WHERE currency_code =:currencyCode")
    suspend fun getExchangeRate(currencyCode : String): Double

    @Query("DELETE FROM ${DBConstants.CURRENCY_TABLE}")
    suspend fun clear()

}