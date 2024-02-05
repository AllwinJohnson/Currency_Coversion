package com.allwin.currencycoversion.data.di


import com.allwin.currencycoversion.data.database.dataSource.LocalDataSource
import com.allwin.currencycoversion.data.network.dataSource.RemoteDataSource
import com.allwin.currencycoversion.data.repository.CurrencyRepository
import com.allwin.currencycoversion.data.repository.CurrencyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCurrencyRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): CurrencyRepository =
        CurrencyRepositoryImpl(remoteDataSource, localDataSource)

}
