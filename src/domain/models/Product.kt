package domain.models

data class Product(
    val id: Int,
    val idCategory: Int,
    val nombre: String,
    val modelo: String,
    val precio: Double
)