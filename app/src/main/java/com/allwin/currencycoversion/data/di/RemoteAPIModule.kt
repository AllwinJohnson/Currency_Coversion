package com.allwin.currencycoversion.data.di

import com.allwin.currencycoversion.BuildConfig
import com.allwin.currencycoversion.data.network.AuthorizationInterceptor
import com.allwin.currencycoversion.data.network.CurrencyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object RemoteAPIModule {
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AuthClient

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Auth

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Singleton
    @Provides
    fun provideLogInterceptor() = run {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)

        }
        return@run loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) = run {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @AuthClient
    @Provides
    fun provideOkHttpAuthClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ) = run {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(AuthorizationInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()

    @Singleton
    @Auth
    @Provides
    fun provideAuthRetrofit(@AuthClient okHttpClient: OkHttpClient, baseUrl: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(@Auth retrofit: Retrofit): CurrencyService =
        retrofit.create(CurrencyService::class.java)

}