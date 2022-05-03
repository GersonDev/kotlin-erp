package presentation

import domain.models.Order
import domain.models.OrderStatus
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
    }

    fun showCartTotal() {
        println("El total es: ${cartRepository.getCartTotal()}soles.")
    }

    fun showPayments() {
        paymentsRepository.getAllPayment().forEach {
            println("${it.id}.${it.modalidad}")
        }
    }

    fun addNewPayment(paymentId: Int) {
        val selectedPayment = paymentsRepository.getPaymentMethodsById(paymentId)
        cartRepository.setPayment(selectedPayment)
        //creamos la orden luego de hacer el pago
        val order = Order(
            payment = cartRepository.getPayment(),
            products = cartRepository.getAllProducts(),
            status = OrderStatus.COMPLETED,
            total = cartRepository.getCartTotal()
        )
        ordersRepository.addNewOrder(order)
    }

    fun showAllOrders() {
        ordersRepository.getAllOrder().forEach {
            println("Producto(s) a pagar:\n${it.products}")
            println("El total es:\n${it.total}")
            println("Su medio de pago seleccionado es:\n${it.payment}")
            println("FASE ${it.status}")

        }
    }
}

