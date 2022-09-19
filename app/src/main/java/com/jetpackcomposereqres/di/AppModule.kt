package com.jetpackcomposereqres.di

import com.jetpackcomposereqres.common.Constants.BASE_URL
import com.jetpackcomposereqres.data.remote.network.ApiServices
import com.jetpackcomposereqres.data.repository.RepositoryImpl
import com.jetpackcomposereqres.domain.repository.Repository
import com.jetpackcomposereqres.domain.usecase.GetSingleUserUseCase
import com.jetpackcomposereqres.domain.usecase.GetUserListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun providesRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun providesApiServices(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }

    @Singleton
    @Provides
    fun providesRepositoryProvide(apiServices: ApiServices): Repository = RepositoryImpl(apiServices)

    @Singleton
    @Provides
    fun providesGetUserListUseCase(repository: Repository): GetUserListUseCase =
        GetUserListUseCase(repository)

    @Singleton
    @Provides
    fun providesGetSingleUserUseCase(repository: Repository): GetSingleUserUseCase =
        GetSingleUserUseCase(repository)
}