package com.allwin.currencycoversion

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.allwin.currencycoversion.ui.home.HomeActivity
import com.allwin.currencycoversion.ui.home.viewModel.HomeViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class HomeActivityTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var activityScenarioRule = activityScenarioRule<HomeActivity>()

    @Inject
    lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
    }

    @Test
    fun testCurrencyListDisplayed() {

        launchActivity<HomeActivity>().use { scenario ->
            scenario.onActivity { activity ->
                activity.viewModel.getCurrencies()

            }

        }
    }
}