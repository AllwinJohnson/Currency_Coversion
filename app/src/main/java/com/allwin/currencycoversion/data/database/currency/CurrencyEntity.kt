package com.allwin.currencycoversion.data.database.currency

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.allwin.currencycoversion.data.database.DBConstants

@Entity(tableName = DBConstants.CURRENCY_TABLE)
class CurrencyEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "currency_code")
    val currencyCode: String,

    @ColumnInfo(name = "exchange_rate")
    val exchangeRate: Double,

)