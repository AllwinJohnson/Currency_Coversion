package com.allwin.currencycoversion.data.network

import com.allwin.currencycoversion.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class AuthorizationInterceptor () : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().signedRequest()
        return chain.proceed(newRequest)
    }

    private fun Request.signedRequest(): Request {

        return newBuilder()
            .header("Authorization", "Token ${BuildConfig.EXCHANGE_API_KEY}")
            .build()
    }
}