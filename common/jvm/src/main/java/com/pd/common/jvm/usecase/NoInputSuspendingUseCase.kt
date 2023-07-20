package com.pd.common.jvm.usecase

interface NoInputSuspendingUseCase<out O> {
    suspend fun execute(): O
}