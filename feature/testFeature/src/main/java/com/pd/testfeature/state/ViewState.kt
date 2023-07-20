package com.pd.testfeature.state

import com.pd.domain.entity.Products

data class ViewState(
    val loading: Boolean = false,
    val products: Products? = null,
    val error: String? = null
) {
    companion object {
         fun initialState() = ViewState()
    }
}
