package com.pd.network.creator

import com.squareup.moshi.Moshi

interface ApiServiceCreator {
    fun <T> create(
        serviceClass: Class<T>,
        baseOverrideUrl: String? = null,
        moshiOverride: Moshi.Builder? = null
    ): T
}