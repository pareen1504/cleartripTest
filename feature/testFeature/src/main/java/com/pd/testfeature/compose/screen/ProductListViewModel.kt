package com.pd.testfeature.compose.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pd.domain.usecase.GetAllProductsUseCase
import com.pd.testfeature.state.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(ViewState.initialState())
    val viewState = _viewState.asStateFlow()

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        _viewState.update { oldValue -> oldValue.copy(loading = true) }
        viewModelScope.launch {
            getAllProductsUseCase.execute().onEach {
                _viewState.update { oldValue ->
                    oldValue.copy(products = it)
                }
            }.catch {
                _viewState.update { oldValue ->
                    oldValue.copy(
                        error = it.message,
                        products = null
                    )
                }
            }.launchIn(viewModelScope)
        }
    }
}