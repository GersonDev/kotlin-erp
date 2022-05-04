package domain.models

import java.util.*

data class Order(
        val id: String = UUID.randomUUID().toString(),
        val paymentsMade: MutableList<Payment> = mutableListOf(),
        val products: MutableList<Product> = mutableListOf(),
        val status: OrderStatus,
        val total: Double
)