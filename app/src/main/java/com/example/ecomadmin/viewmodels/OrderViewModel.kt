package com.example.ecomadmin.viewmodels

import androidx.lifecycle.ViewModel
import com.example.ecomadmin.models.Order
import com.example.ecomadmin.models.OrderDetails
import com.example.ecomadmin.models.OrderSettings
import com.example.ecomadmin.repos.OrderRepository
import com.example.ecomadmin.utils.DBResult

class OrderViewModel : ViewModel() {
    private val orderRepository = OrderRepository()

    fun getOrderSettings() = orderRepository.getOrderSettings()

    fun getDiscountAmount(total: Double, settings: OrderSettings) : Double {
        return (total * settings.discount) / 100
    }

    fun getVatAmount(total: Double, settings: OrderSettings) : Double {
        val priceAfterDiscount = total - getDiscountAmount(total, settings)
        return (priceAfterDiscount * settings.vat) / 100
    }

    fun getGrandTotal(total: Double, settings: OrderSettings) : Double{
        return total - getDiscountAmount(total, settings) + getVatAmount(total, settings) + settings.deliveryCharge
    }

    fun addNewOrder(
        order: Order,
        orderDetailsList: MutableList<OrderDetails>,
        callback: (DBResult) -> Unit) {
        orderRepository.addNewOrder(order, orderDetailsList, callback)
    }

    fun getOrderByUser(userId: String) = orderRepository.getOrderByUser(userId)
}