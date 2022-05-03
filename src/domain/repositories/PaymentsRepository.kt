package domain.repositories

import domain.models.Payment

class PaymentsRepository {
    private val payments: List<Payment> = listOf(
        Payment(1, "Efectivo"),
        Payment(2, "Tarjeta de Credito o Debito"),
        Payment(3, "Bit Coin")
    )
    fun getAllPayment(): List<Payment> {
        return payments
    }
    fun getPaymentMethodsById(id: Int): Payment {
        return payments.first {
            it.id == id
        }
    }
}