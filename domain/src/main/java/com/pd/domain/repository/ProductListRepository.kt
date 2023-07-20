package com.pd.domain.repository

import com.pd.domain.entity.Products

interface ProductListRepository {
    suspend fun getProducts(): Result<Products>
}