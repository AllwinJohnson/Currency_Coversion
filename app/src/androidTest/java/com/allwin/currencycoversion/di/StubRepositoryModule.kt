package com.allwin.currencycoversion.di

import com.allwin.currencycoversion.data.di.RepositoryModule
import com.allwin.currencycoversion.data.repository.CurrencyRepository
import com.allwin.currencycoversion.repository.StubCurrencyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton


@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
abstract class StubRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindStudCurrencyRepository(stubCurrencyRepositoryImpl: StubCurrencyRepositoryImpl): CurrencyRepository

}