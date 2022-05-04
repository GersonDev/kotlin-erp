package domain.repositories

import domain.models.Payment
import domain.models.Product

class CartRepository {
    private val products: MutableList<Product> = mutableListOf()
    private val paymentsMade: MutableList<Payment> = mutableListOf()

    // region payments
    fun addNewPayment(payment: Payment) {
        paymentsMade.add(payment)
    }

    fun getAllPaymentsMade(): List<Payment> {
        return paymentsMade
    }

    fun getTotalPaymentsMade(): Double {
        var sumaPaymentsTotal = 0.0
        paymentsMade.forEach {
            sumaPaymentsTotal += it.amount
        }
        return sumaPaymentsTotal
    }
    // endregion

    // region products
    fun addNewProduct(product: Product) {
        products.add(product)
    }

    fun getAllProducts(): List<Product> {
        return products
    }

    fun getCartTotal(): Double {
        var sumatotal: Double = 0.0
        products.forEach {
            sumatotal += it.precio
        }
        return sumatotal
    }
    // endregion

    fun getBalance(): Double {
        val balance = getCartTotal() - getTotalPaymentsMade()
        return balance
    }

    fun isReadyForCreatingOrder(): Boolean {
        return getBalance() == 0.0
    }

    fun clean() {
        products.clear()
        paymentsMade.clear()
    }
}