package com.example.deliveryapp.restaurant.data.remote.requests

import com.google.gson.annotations.SerializedName

data class DispatchedOrderRequest(
    @SerializedName("id") val idOrder: String,
    @SerializedName("id_client") val idClient: String,
    @SerializedName("id_address") val idAddress: String,
    @SerializedName("id_delivery") val idDelivery: String,
    @SerializedName("status") val status: String,
)
