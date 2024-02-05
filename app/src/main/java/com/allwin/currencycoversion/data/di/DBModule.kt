package com.allwin.currencycoversion.data.di


import android.content.Context
import com.allwin.currencycoversion.data.database.CCDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): CCDatabase =
        CCDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCurrencyDao(db: CCDatabase) = db.currencyDao()

}
