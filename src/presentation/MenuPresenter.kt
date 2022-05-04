package presentation

import domain.models.Order
import domain.models.OrderStatus
import domain.models.Payment
import domain.repositories.*

class MenuPresenter {
    private val categoriesRepository: CategoriesRepository = CategoriesRepository()
    private val productsRepository: ProductsRepository = ProductsRepository()
    private val cartRepository: CartRepository = CartRepository()
    private val paymentsRepository: PaymentsRepository = PaymentsRepository()
    private val ordersRepository: OrdersRepository = OrdersRepository()

    fun showMainTitle() {
        println("**********************")
        println("SUPERMERCADO METRO")
        println("**********************")

        println("1.Ver Lista de Articulos u Productos")
        println("2.Carrito de Compras")
        println("3.Medio de Pagos")
        println("4.Ver Ordenes de compras")
        println("5.Exit")

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
        println("Los Pagos del carrito son:")
        cartRepository.getAllPaymentsMade().forEach {
            println("$it")
        }

        println("TOTAL:  ${cartRepository.getCartTotal()}")
        println("BALANCE:  ${cartRepository.getBalance()}")
    }

    fun showPayments() {
        paymentsRepository.getAllPayment().forEach {
            println("${it.id}.${it.modalidad}")
        }
    }

    fun showAmountMessage() {
        println("Coloque su monto")
    }

    fun addNewPayment(paymentId: Int, amount: Double) {
        // 1. el usuario selecciona su medio de pago
        val selectedPayment: Payment = paymentsRepository.getPaymentMethodsById(paymentId)
        selectedPayment.amount = amount
        cartRepository.addNewPayment(selectedPayment)

        if (cartRepository.isReadyForCreatingOrder()) {
            // 2. se crea la orden luego de hacer el pago
            val order = Order(
                    status = OrderStatus.COMPLETED,
                    total = cartRepository.getCartTotal()
            )
            order.paymentsMade.addAll(cartRepository.getAllPaymentsMade())
            order.products.addAll(cartRepository.getAllProducts())
            ordersRepository.addNewOrder(order)

            // 3. limpiamos el carrito
            cartRepository.clean()
        }
    }

    fun showAllOrders() {
        ordersRepository.getAllOrder().forEach {
            println("Orden #${it.id}")
            println("\t\tProducto(s) a pagar:\n${it.products}")
            println("\t\tEl total es:\n${it.total}")
            println("\t\tSu medio de pago seleccionado es:\n${it.paymentsMade}")
            println("\t\tFASE ${it.status}")

        }
    }
}

