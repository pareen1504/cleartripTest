package com.pd.domain.di

import com.pd.domain.usecase.GetAllProductsUseCase
import com.pd.domain.usecase.impl.GetAllProductsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    @Singleton
    abstract fun bindsGetAllProductsUseCase(getAllProductsUseCaseImpl: GetAllProductsUseCaseImpl): GetAllProductsUseCase
}