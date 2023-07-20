package com.pd.testfeature.di

import com.pd.domain.di.DomainModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DomainModule::class])
@InstallIn(SingletonComponent::class)
abstract class ProductListModule