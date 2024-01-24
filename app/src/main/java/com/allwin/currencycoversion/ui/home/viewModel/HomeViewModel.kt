package com.allwin.currencycoversion.ui.home.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.allwin.currencycoversion.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    private val _tvInput = MutableLiveData<String>()
    val tvInput: LiveData<String> get() = _tvInput

    private val _tvOutput = MutableLiveData<Double>()
    val tvOutput: LiveData<Double> get() = _tvOutput

    fun onNumericButtonClick(number: String) {
        _tvInput.value = "${_tvInput.value.orEmpty()}$number"
    }

    fun onDotButtonClick() {
        val currentInput = _tvInput.value.orEmpty()
        if (!currentInput.contains(".")) {
            _tvInput.value = "$currentInput."
        }
    }

    fun onClearButtonClick() {
        _tvInput.value = ""
    }

    fun convert(newText: String) {
        val input = newText.toDoubleOrNull()

        val currentExchangeRate = exchangeRate
        val currentUsdRate = usdRate

        if (input != null && currentExchangeRate != null && currentUsdRate != null) {
            _tvOutput.value = (input * currentExchangeRate) / currentUsdRate
        } else {
            _tvOutput.value = 0.0
        }
    }
}