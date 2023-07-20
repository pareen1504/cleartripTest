package com.pd.common.jvm.mapper

interface Mapper<in I, out O> {
    suspend fun map(input: I): O
}