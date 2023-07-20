package com.pd.common.jvm.usecase

interface SuspendingUseCase<in I, out O> {
    suspend fun execute(input: I): O
}