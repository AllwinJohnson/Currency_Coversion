package com.allwin.currencycoversion.data.repository

import com.allwin.currencycoversion.data.database.currency.CurrencyEntity
import com.allwin.currencycoversion.data.database.dataSource.LocalDataSource
import com.allwin.currencycoversion.data.model.currency.CurrencyResponse
import com.allwin.currencycoversion.data.network.NetworkResult
import com.allwin.currencycoversion.data.network.dataSource.RemoteDataSource
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,

) : CurrencyRepository{
    override suspend fun getCurrencies(
    ): Flow<NetworkResult<CurrencyResponse>> {
        return flow {
            emit(NetworkResult.Loading())
            val currencyResponse: Response<CurrencyResponse> =
                remoteDataSource.getCurrencies()

            if (currencyResponse.isSuccessful) {
                currencyResponse.body()?.let {

                    val currencyList = mutableListOf<CurrencyEntity>()
                    val rateFields = it.rates!!::class.java.declaredFields
                    rateFields.forEach { field ->
                        field.isAccessible = true
                        val currencyCode = field.name
                        val exchangeRate = field.get(it.rates)?.toString()?.toDoubleOrNull()
                        exchangeRate?.let { exchangeRateConverted ->
                            currencyList.add(CurrencyEntity(currencyCode, exchangeRateConverted))
                        }
                    }

//                    insert rates to table
                    localDataSource.insertCurrencies(currencyList)
                    return@flow emit(NetworkResult.Success(it))
                }
            }
            val errorMessage = currencyResponse.errorBody()?.string() ?: "Unknown error"
            val errorResponse = Gson().fromJson(errorMessage, CurrencyResponse::class.java)
            val error = errorResponse?.description ?: "Unknown error"
            return@flow emit(NetworkResult.Error(error, currencyResponse.code()))
        }.flowOn(Dispatchers.IO).catch { exceptions ->
            Timber.e("error $exceptions")
            emit(NetworkResult.Failure(exceptions))

        }
    }


     override suspend fun getAllCurrencies() = localDataSource.getAllCurrencies()
     override suspend fun getExchangeRate(currencyCode: String) =
        localDataSource.getExchangeRate(currencyCode)
}