package com.pd.domain.entity

data class Products(
    val total: Int = 0,
    val limit: Int = 0,
    val skip: Int = 0,
    val productsItems: List<ProductsItem>? = null
) {
    data class ProductsItem(
        val discountPercentage: Double = 0.0,
        val thumbnail: String = "",
        val images: List<String>?,
        val price: Int = 0,
        val rating: Double = 0.0,
        val description: String = "",
        val id: Int = 0,
        val title: String = "",
        val stock: Int = 0,
        val category: String = "",
        val brand: String = ""
    )
}
