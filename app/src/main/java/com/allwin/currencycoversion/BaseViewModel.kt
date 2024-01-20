package com.allwin.currencycoversion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allwin.currencycoversion.data.network.NetworkResult
import com.allwin.currencycoversion.data.repository.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(
    application: Application,
) : AndroidViewModel(application) {

    @Inject
    lateinit var currencyRepository: CurrencyRepository

    private val _currencyList = MutableLiveData<List<String>>()
    val currencyList: LiveData<List<String>> get() = _currencyList

    fun getCurrencies() {
        viewModelScope.launch {
            currencyRepository.getCurrencies().collect { result ->

                when (result) {
                    is NetworkResult.Loading -> {

                    }

                    is NetworkResult.Success -> {
                        viewModelScope.launch {
                            loadCurrencies()
                        }
                    }

                    is NetworkResult.Error -> {

                    }

                    is NetworkResult.Failure -> {

                    }
                }
            }
        }
    }

    private fun loadCurrencies() {
        viewModelScope.launch {
            _currencyList.value = currencyRepository.getAllCurrencies()
        }
    }

    suspend fun getRate(currencyP: Int): Double? {
        var exchangeRate: Double? = null

//        Timber.e("selected ${currencyList.value?.get(currencyP)}")

        val selectedCurrency = currencyList.value?.get(currencyP)
        if (selectedCurrency != null) {
         /*   Timber.e(
                "selected value ${
                    currencyRepository.getExchangeRate(selectedCurrency)
                }"
            )*/

            exchangeRate = currencyRepository.getExchangeRate(selectedCurrency)
        }

        return exchangeRate
    }
}

typealias USD = String

data class USDRateUiState(
    var usd: USD
)