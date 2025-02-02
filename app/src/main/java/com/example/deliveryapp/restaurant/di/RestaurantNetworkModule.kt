package com.example.deliveryapp.restaurant.di

import com.example.deliveryapp.auth.data.remote.AuthApiService
import com.example.deliveryapp.restaurant.data.remote.RestaurantApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestaurantNetworkModule {
    @Provides
    @Singleton
    fun provideCategoryApiService(
        retrofit: Retrofit
    ): RestaurantApiService{
        return retrofit.create(RestaurantApiService::class.java)
    }
}