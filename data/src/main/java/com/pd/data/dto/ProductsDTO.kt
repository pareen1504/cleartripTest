package com.pd.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductsDTO(
    @Json(name = "total")
    val total: Int = 0,
    @Json(name = "limit")
    val limit: Int = 0,
    @Json(name = "skip")
    val skip: Int = 0,
    @Json(name = "products")
    val productsItems: List<ProductsItemDTO>? = null
) {
    @JsonClass(generateAdapter = true)
    data class ProductsItemDTO(
        @Json(name = "discountPercentage")
        val discountPercentage: Double = 0.0,
        @Json(name = "thumbnail")
        val thumbnail: String = "",
        @Json(name = "images")
        val images: List<String>?,
        @Json(name = "price")
        val price: Int = 0,
        @Json(name = "rating")
        val rating: Double = 0.0,
        @Json(name = "description")
        val description: String = "",
        @Json(name = "id")
        val id: Int = 0,
        @Json(name = "title")
        val title: String = "",
        @Json(name = "stock")
        val stock: Int = 0,
        @Json(name = "category")
        val category: String = "",
        @Json(name = "brand")
        val brand: String = ""
    )
}


