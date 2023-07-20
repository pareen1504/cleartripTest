package com.pd.data.mapper

import com.pd.common.jvm.mapper.Mapper
import com.pd.data.dto.ProductsDTO
import com.pd.domain.entity.Products

object ProductItemDTOToProductItemMapper :
    Mapper<List<ProductsDTO.ProductsItemDTO>, List<Products.ProductsItem>> {
    override suspend fun map(input: List<ProductsDTO.ProductsItemDTO>): List<Products.ProductsItem> =
        input.map { items ->
            Products.ProductsItem(
                discountPercentage = items.discountPercentage,
                thumbnail = items.thumbnail,
                images = items.images,
                price = items.price,
                rating = items.rating,
                description = items.description,
                id = items.id,
                title = items.title,
                stock = items.stock,
                category = items.category,
                brand = items.brand,
            )
        }
}