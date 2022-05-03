package domain.repositories

import domain.models.Order
import domain.models.OrderStatus
import domain.models.Payment
import domain.models.Product

class OrdersRepository {
    private val orders: MutableList<Order> = mutableListOf()
    fun addNewOrder(order:Order) {
        orders.add(order)
    }
    fun getAllOrder(): List<Order> {
        return orders
    }
}