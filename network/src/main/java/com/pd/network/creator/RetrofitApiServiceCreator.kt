package com.pd.network.creator

import com.squareup.moshi.Moshi
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val BASE_URL = "https://dummyjson.com"

class RetrofitApiServiceCreator @Inject constructor(
    moshi: Moshi
) : ApiServiceCreator {

    private val okHttpClient = OkHttpClient.Builder().apply {
        connectionPool(
            ConnectionPool(
                maxIdleConnections = 5,
                keepAliveDuration = 5,
                timeUnit = TimeUnit.SECONDS
            )
        )
        addInterceptor(
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
    }.build()

    private val defaultMoshi: Moshi = moshi.newBuilder().build()

    override fun <T> create(
        serviceClass: Class<T>,
        baseOverrideUrl: String?,
        moshiOverride: Moshi.Builder?
    ): T = createRetrofitBuilder(baseOverrideUrl, moshiOverride).build().create(serviceClass)

    private fun createRetrofitBuilder(baseOverrideUrl: String?, moshiOverride: Moshi.Builder?) =
        with(Retrofit.Builder()) {
            client(okHttpClient)
            addConverterFactory(
                MoshiConverterFactory.create(
                    moshiOverride?.build() ?: defaultMoshi
                )
            )
            baseUrl(baseOverrideUrl ?: BASE_URL)
        }
}