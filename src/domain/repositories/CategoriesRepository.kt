package domain.repositories

import domain.models.Category

class CategoriesRepository {
    private val categories: List<Category> = listOf(
        Category(1, "ELECTRODOMESTICOS"),
        Category(2, "DORMITORIOS"),
        Category(3, "AGUAS Y BEBIDAS"),
        Category(4, "TECNOLOGIAS"),
        Category(5, "PANADERIA Y PASTELERIAS"),
        Category(6, "ABARROTES")
    )

    fun getAllCategory(): List<Category> {
        return categories
    }
}