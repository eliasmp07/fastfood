package com.example.deliveryapp.client.domain.useCases

import com.example.deliveryapp.client.domain.model.Category
import com.example.deliveryapp.client.domain.model.ResponseClient
import com.example.deliveryapp.client.domain.repository.ClientRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class GetAllCategoriesUseCase(
    private val repository: ClientRepository
) {
    suspend operator fun invoke(): Flow<ResponseClient<List<Category>>>{
        return withContext(Dispatchers.IO){
            repository.getAllCategories()
        }
    }
}