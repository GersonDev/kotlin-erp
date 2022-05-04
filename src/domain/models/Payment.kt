package domain.models

data class Payment(
    val id: Int,
    val modalidad: String,
    var amount: Double
)