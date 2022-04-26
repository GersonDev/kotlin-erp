package presentation

import domain.repositories.CategoriesRepository
import domain.repositories.ProductsRepository

class MenuPresenter {
    private val categoriesRepository: CategoriesRepository = CategoriesRepository()
    private val productsRepository: ProductsRepository = ProductsRepository()

    fun showMainTitle() {
        println("**********************")
        println("SUPERMERCADO METRO")
        println("**********************")

        println("1.Ver Lista de Articulos u Productos")
    }

    fun showMainMenu() {
        val cateries = categoriesRepository.getAllCategory()
        cateries.forEach { category ->
            println("${category.nombre}:")
            val products = productsRepository.getProductsByCategoryId(category.id)
            products.forEach {
                println("${it.id}.${it.nombre}.${it.modelo}.${it.precio}")
            }

        }
    }

    fun showOptioncontinueSelecting() {
        println("Desea elegir otro producto!")
        println("1.Yes")
        println("2.No")
    }
}