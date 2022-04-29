package domain.repositories

import domain.models.Product

class CartRepository {
    private val products: MutableList<Product> = mutableListOf()
    fun addNewProduct(product: Product) {
        products.add(product)
    }

    fun getCartByUuid(id: Int): Product {
        return products.first {
            it.id == id
        }
    }

    fun getAllProducts(): List<Product> {
        return products
    }

    fun getCartTotal(): Double {
        var sumatotal:Double=0.0
        products.forEach {
            sumatotal+=it.precio
        }
        return sumatotal
    }
}