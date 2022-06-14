package com.example.ecomadmin.models
import com.example.ecomadmin.utils.OrderStatus
import com.example.ecomadmin.utils.PaymentMethod
import com.google.firebase.Timestamp

data class Order(
    var orderId: String? = null,
    var userId: String? = null,
    var orderDate: Timestamp? = null,
    var deliveryCharge: Int = 0,
    var discount: Int = 0,
    var vat: Int = 0,
    var grandTotal: Double? = null,
    var orderStatus: String = OrderStatus.pending,
    var paymentMethod: String = PaymentMethod.cod,
    var deliveryAddress: String? = null,
)
