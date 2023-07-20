package com.pd.data.repository

import com.pd.data.api.ProductListApi
import com.pd.data.mapper.ProductsDTOToProductMapper
import com.pd.domain.entity.Products
import com.pd.domain.repository.ProductListRepository
import javax.inject.Inject

class ProductListRepositoryImpl @Inject constructor(
    private val productListApi: ProductListApi
) : ProductListRepository {
    override suspend fun getProducts(): Result<Products> = runCatching {
        val response = productListApi.getAllProducts()
        val products = response.body()
        if (response.isSuccessful) {
            ProductsDTOToProductMapper.map(products)
        } else {
            error("No data available")
        }
    }
}