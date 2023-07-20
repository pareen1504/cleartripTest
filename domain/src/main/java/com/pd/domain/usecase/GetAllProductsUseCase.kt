package com.pd.domain.usecase

import com.pd.common.jvm.usecase.NoInputSuspendingUseCase
import com.pd.domain.entity.Products
import kotlinx.coroutines.flow.Flow


interface GetAllProductsUseCase : NoInputSuspendingUseCase<Flow<Products>>