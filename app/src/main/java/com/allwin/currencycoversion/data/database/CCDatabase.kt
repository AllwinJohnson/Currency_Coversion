package com.allwin.currencycoversion.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.allwin.currencycoversion.data.database.currency.CurrencyDao
import com.allwin.currencycoversion.data.database.currency.CurrencyEntity


@Database(
    version = 1,
    entities = [
        CurrencyEntity::class
    ],
    exportSchema = true
)

abstract class CCDatabase : RoomDatabase() {

    abstract fun currencyDao(): CurrencyDao

    companion object {

        @Volatile
        private var instance: CCDatabase? = null

        fun getDatabase(context: Context): CCDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, CCDatabase::class.java, DBConstants.DATABASE_NAME)
                .build()
    }
}