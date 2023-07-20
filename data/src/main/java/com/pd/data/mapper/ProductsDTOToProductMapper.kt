package com.pd.data.mapper

import com.pd.common.jvm.mapper.Mapper
import com.pd.data.dto.ProductsDTO
import com.pd.domain.entity.Products

object ProductsDTOToProductMapper : Mapper<ProductsDTO?, Products> {
    override suspend fun map(input: ProductsDTO?): Products =
        Products(
            total = input?.total ?: 0,
            limit = input?.limit ?: 0,
            skip = input?.skip ?: 0,
            productsItems = input?.productsItems?.let { ProductItemDTOToProductItemMapper.map(it) },
        )
}