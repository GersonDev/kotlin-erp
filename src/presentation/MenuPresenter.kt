package presentation

import domain.repositories.CartRepository
import domain.repositories.CategoriesRepository
import domain.repositories.ProductsRepository

class MenuPresenter {
    private val categoriesRepository: CategoriesRepository = CategoriesRepository()
    private val productsRepository: ProductsRepository = ProductsRepository()
    private val cartRepository: CartRepository = CartRepository()

    fun showMainTitle() {
        println("**********************")
        println("SUPERMERCADO METRO")
        println("**********************")

        println("1.Ver Lista de Articulos u Productos")
    }

    fun showMainMenu() {
        val categories = categoriesRepository.getAllCategory()
        categories.forEach { category ->
            println("${category.id}.${category.nombre}:")

        }
    }

    fun showAllProductsByCategoryId(idCategory: Int) {
        val products = productsRepository.getProductsByCategoryId(idCategory)
        val categoryfound = products.filter {
            it.idCategory == idCategory
        }
        categoryfound.forEach {
            println("${it.id}.${it.nombre}.\nmodelo o tipo:${it.modelo}.\n precio:${it.precio}")
        }
    }

    fun showOptioncontinueSelecting() {
        println("Desea elegir otro producto!")
        println("1.Yes")
        println("2.No")
    }

    fun addNewProduct(productId: Int) {
        val selectedProduct = productsRepository.getProductById(productId)
        cartRepository.addNewProduct(selectedProduct)
    }

    fun showCart() {
        println("Los Productos del carrito son:")
        cartRepository.getAllProducts().forEach {
            println("$it")
        }
    }

    fun showCartTotal(){
        println("El total es: ${cartRepository.getCartTotal()}soles.")
    }
}

