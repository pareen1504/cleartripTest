package com.pd.data.di

import com.pd.data.api.ProductListApi
import com.pd.network.creator.ApiServiceCreator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductsApiModule {

    @Provides
    @Singleton
    fun providesProductsApiModule(
        apiServiceCreator: ApiServiceCreator
    ): ProductListApi = apiServiceCreator.create(ProductListApi::class.java)

}