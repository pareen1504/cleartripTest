package com.pd.network.di

import com.pd.network.creator.ApiServiceCreator
import com.pd.network.creator.RetrofitApiServiceCreator
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    @Singleton
    abstract fun bindsApiService(retrofitApiServiceCreator: RetrofitApiServiceCreator): ApiServiceCreator

    companion object {

        @Provides
        @Singleton
        fun providesMoshi(): Moshi = Moshi.Builder().build()
    }
}