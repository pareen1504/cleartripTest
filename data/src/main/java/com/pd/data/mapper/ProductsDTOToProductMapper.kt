package com.pd.data.mapper

import com.pd.common.jvm.mapper.Mapper
import com.pd.data.dto.ProductsDTO
import com.pd.domain.entity.Products

object ProductsDTOToProductMapper : Mapper<ProductsDTO, Products> {
    override suspend fun map(input: ProductsDTO): Products = Products(
        total = input.total,
        limit = input.limit,
        skip = input.skip,
        productsItems = input.productsItems?.let { ProductItemDTOToProductItemMapper.map(it) },
    )
}