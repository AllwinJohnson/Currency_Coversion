package com.allwin.currencycoversion.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.allwin.currencycoversion.databinding.ActivityHomeBinding
import com.allwin.currencycoversion.ui.home.adapter.CurrencyAdapter
import com.allwin.currencycoversion.ui.home.viewModel.HomeViewModel
import com.allwin.currencycoversion.util.extension.formatRate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var _binding: ActivityHomeBinding
    val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: CurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        bindView()
        observer()

    }

    private fun bindView() {
        viewModel.getCurrencies()
        _binding.apply {

            bt1.setOnClickListener { viewModel.onNumericButtonClick(bt1.text.toString()) }
            bt2.setOnClickListener { viewModel.onNumericButtonClick(bt2.text.toString()) }
            bt3.setOnClickListener { viewModel.onNumericButtonClick(bt3.text.toString()) }
            bt4.setOnClickListener { viewModel.onNumericButtonClick(bt4.text.toString()) }
            bt5.setOnClickListener { viewModel.onNumericButtonClick(bt5.text.toString()) }
            bt6.setOnClickListener { viewModel.onNumericButtonClick(bt6.text.toString()) }
            bt7.setOnClickListener { viewModel.onNumericButtonClick(bt7.text.toString()) }
            bt8.setOnClickListener { viewModel.onNumericButtonClick(bt8.text.toString()) }
            bt9.setOnClickListener { viewModel.onNumericButtonClick(bt9.text.toString()) }
            bt0.setOnClickListener { viewModel.onNumericButtonClick(bt0.text.toString()) }

            btDot.setOnClickListener { viewModel.onDotButtonClick() }
            btC.setOnClickListener { viewModel.onClearButtonClick() }

            viewModel.tvInput.observe(this@HomeActivity) { updatedInput ->
                tvInput.text = updatedInput
            }

            tvInput.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    viewModel.convert(s.toString())
                }
            })
        }
    }

    private fun observer() {
        viewModel.currencyList.observe(this@HomeActivity) { currencies ->
            val mutableCurrencies = currencies.toMutableList()
            _binding.apply {
                adapter = CurrencyAdapter(this@HomeActivity, mutableCurrencies)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spCurrencies.adapter = adapter
                spCurrencies.onItemSelectedListener = this@HomeActivity
            }
        }

        viewModel.tvInput.observe(this) { updatedInput ->
            _binding.tvInput.text = updatedInput
        }


        viewModel.tvOutput.observe(this) { updatedOutput ->
            _binding.tvExchange.text = updatedOutput.formatRate()
        }

    }

    @SuppressLint("SetTextI18n")
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        lifecycleScope.launch {
            val rateDeferred = async { viewModel.getRate(p2) }
            val rate = rateDeferred.await()

            val convertedValueDeferred =
                async { viewModel.convert(_binding.tvInput.text.toString()) }
            convertedValueDeferred.await()

            _binding.apply {
                tvRate.text = "1 USD ~~ ${rate.formatRate()}"
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}
