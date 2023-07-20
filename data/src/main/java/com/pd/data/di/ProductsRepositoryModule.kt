package com.pd.data.di

import com.pd.data.repository.ProductListRepositoryImpl
import com.pd.domain.repository.ProductListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsProductListRepository(productListRepositoryImpl: ProductListRepositoryImpl): ProductListRepository
}