package com.example.ecomadmin.models

data class OrderDetails(
    var productId: String? = null,
    var productName: String? = null,
    var productPrice: Double = 0.0,
    var productQuantity: Int = 0
)
