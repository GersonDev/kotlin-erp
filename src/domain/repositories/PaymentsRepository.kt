package domain.repositories

import domain.models.Payment

class PaymentsRepository {
    private val payments: List<Payment> = listOf(
        Payment(1, "Efectivo", 0.0),
        Payment(2, "Tarjeta de Credito o Debito", 0.0),
        Payment(3, "Bit Coin", 0.0)
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