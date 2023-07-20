package com.pd.testfeature.compose.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pd.domain.entity.Products
import com.pd.testfeature.compose.elements.ProductItem

@Composable
fun ProductsListScreen() {
    val viewModel = hiltViewModel<ProductListViewModel>()
    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    LazyColumn {
        itemsIndexed(
            item = viewState.value.products?.productsItems,
            key = { _: Int, items: Products.ProductsItem -> items.id },
        ) { _: Int, productItem: Products.ProductsItem ->
            ProductItem(
                image = { productItem.thumbnail },
                name = { productItem.title },
                price = { productItem.price.toString() },
                rating = { productItem.rating.toString() }
            )
        }
    }
}