package com.pd.testfeature.compose.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pd.domain.entity.Products
import com.pd.testfeature.compose.elements.ProductItem

@Composable
fun ProductsListScreen() {
    val viewModel = hiltViewModel<ProductListViewModel>()
    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    if (viewState.value.error.isNullOrEmpty().not()) {
        Toast.makeText(
            LocalContext.current, viewState.value.error, Toast.LENGTH_LONG
        ).show()
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            verticalArrangement = Arrangement.Center,
            state = rememberLazyGridState()
        ) {
            itemsIndexed(
                items = viewState.value.products?.productsItems ?: emptyList(),
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
}