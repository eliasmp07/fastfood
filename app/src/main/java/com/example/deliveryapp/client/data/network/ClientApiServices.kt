package com.example.deliveryapp.client.data.network

import com.example.deliveryapp.client.data.network.dto.category.CategoryDto
import com.example.deliveryapp.client.data.network.dto.category.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ClientApiServices {
    @GET("category/getAll")
    suspend fun getAllCategories(
        @Header("Authorization") token: String
    ): List<CategoryDto>

    @GET("product/findByCategory/{id_category}")
    suspend fun getProductsByCategory(
        @Header("Authorization") token: String,
        @Path("id_category") idCategory: String
    ): ProductResponse
}