package com.example.deliveryapp.client.domain.repository

import com.example.deliveryapp.client.domain.model.CartShopping
import com.example.deliveryapp.client.domain.model.CartShoppingSerializable
import com.example.deliveryapp.client.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun addProductToCart(product: Product)
    suspend fun getCartProduct(): List<Product>
    suspend fun removeOneProduct(product: Product)
    suspend fun updateAllCart(cartShopping: CartShopping)
    suspend fun clearCart()
}