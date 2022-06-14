package com.example.ecomadmin.models

data class OrderSettings(
    var deliveryCharge: Double = 0.0,
    var discount: Int = 0,
    var vat: Int = 0
)
