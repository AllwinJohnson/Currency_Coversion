package com.allwin.currencycoversion.ui.home

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.allwin.currencycoversion.databinding.ActivityHomeBinding
import com.allwin.currencycoversion.ui.home.adapter.CurrencyAdapter
import com.allwin.currencycoversion.ui.home.viewModel.HomeViewModel
import com.allwin.currencycoversion.util.extension.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var _binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: CurrencyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        viewModel.getCurrencies()
        bindView()
        observer()

    }

    private fun bindView() {
        _binding.apply {

            /*      adapter = CurrencyAdapter(this@HomeActivity, emptyList())
                  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                  spCurrencies.adapter = adapter
                  spCurrencies.onItemSelectedListener = this@HomeActivity
      */
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
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        lifecycleScope.launch {
            val rate = viewModel.getRate(p2)
            showToast(rate.toString())
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}
