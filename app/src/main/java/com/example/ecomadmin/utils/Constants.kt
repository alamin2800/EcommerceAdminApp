package com.example.ecomadmin.utils

const val collectionAdmin = "Admins"
const val collectionProduct = "Products"
const val collectionPurchase = "Purchases"
const val collectionOrder= "Orders"
const val collectionOrderDetails = "Order Details"
const val collectionUser = "Users"
const val collectionCategory = "Categories"
const val collectionOrderSettings = "Order Settings"
const val documentOrderSettings = "Settings Document"

class PaymentMethod {
    companion object {
        const val cod = "Cash on Delivery"
        const val online = "Online Payment"
    }
}

class OrderStatus {
    companion object {
        const val pending = "Pending"
        const val delivered = "Delivered"
        const val cancelled = "Cancelled"
    }
}

enum class DBResult {
    SUCCESS, FAILURE
}
