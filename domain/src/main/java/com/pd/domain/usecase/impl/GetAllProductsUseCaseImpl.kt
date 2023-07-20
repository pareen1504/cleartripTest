package com.pd.domain.usecase.impl

import com.pd.domain.entity.Products
import com.pd.domain.repository.ProductListRepository
import com.pd.domain.usecase.GetAllProductsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.IllegalArgumentException
import javax.inject.Inject

class GetAllProductsUseCaseImpl @Inject constructor(
    private val productListRepository: ProductListRepository
) : GetAllProductsUseCase {
    override suspend fun execute(): Flow<Products> = flow {
        productListRepository.getProducts().fold(
            onSuccess = { products ->
                emit(products)
            },
            onFailure = {
                throw IllegalArgumentException(it.message)
            }
        )
    }
}