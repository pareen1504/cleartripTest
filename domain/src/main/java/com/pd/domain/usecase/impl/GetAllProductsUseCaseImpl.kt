package com.pd.domain.usecase.impl

import com.pd.domain.repository.ProductListRepository
import com.pd.domain.usecase.GetAllProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllProductsUseCaseImpl @Inject constructor(
    private val productListRepository: ProductListRepository
) : GetAllProductsUseCase {
    override suspend fun execute() = flow {
        productListRepository.getProducts().fold(
            onSuccess = { products ->
                emit(products)
            },
            onFailure = {
                throw IllegalArgumentException(it.message)
            }
        )
    }.flowOn(Dispatchers.IO)
}