package com.allwin.currencycoversion

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import com.allwin.currencycoversion.data.model.currency.CurrencyResponse
import com.allwin.currencycoversion.data.network.NetworkResult
import com.allwin.currencycoversion.repository.StubCurrencyRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BaseViewModelTest {

    private lateinit var viewModel: BaseViewModel
    private lateinit var currencyRepository: StubCurrencyRepositoryImpl

/*    @get:Rule
    val hiltRule = HiltAndroidRule(this)
*/

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesDispatcherRule = MainDispatcherRule()

    @Before
    fun setUp() {
        currencyRepository = StubCurrencyRepositoryImpl()
        viewModel = BaseViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun test_getCurrencies_success() = runTest {
        viewModel.getCurrencies()
        assertEquals(listOf("USD", "EUR", "GBP"), viewModel.currencyList.value)
    }

    @Test
    fun test_getCurrencies_failure() = runTest {
        currencyRepository = object : StubCurrencyRepositoryImpl() {
            override suspend fun getCurrencies(): Flow<NetworkResult<CurrencyResponse>> {
                return flow {
                    emit(NetworkResult.Error("Failed to fetch currencies", 500))
                }
            }
        }
        viewModel = BaseViewModel(ApplicationProvider.getApplicationContext())

        viewModel.getCurrencies()

        assertNull(viewModel.currencyList.value)
    }
}