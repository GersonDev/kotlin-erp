package domain.models

data class Order(
    val payment: Payment?,
    val products: List<Product>,
    val status: OrderStatus,
    val total: Double
)