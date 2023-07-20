package com.pd.testfeature.di

import com.pd.domain.usecase.GetAllProductsUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [GetAllProductsUseCase::class])
@InstallIn(SingletonComponent::class)
abstract class ProductListModule