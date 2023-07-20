package com.pd.data.api

import com.pd.data.dto.ProductsDTO
import retrofit2.Response
import retrofit2.http.GET

interface ProductListApi {
    @GET("/products")
    fun getAllProducts(): Response<ProductsDTO>
}