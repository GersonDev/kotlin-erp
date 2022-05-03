import domain.models.Category
import domain.repositories.CartRepository
import domain.repositories.PaymentsRepository
import presentation.MenuPresenter
import util.*

fun main(array: Array<String>) {
    var runMainProgram = true
    var runCategorySubMenu = true
    // Presenters
    var selectedCategoryOption = 0
    var selectedProductOption = 0
    var selectedPaymentOption=0

    val menuPresenter = MenuPresenter()

    var mainManuOption = 0
    var answer = 0

    while (runMainProgram) {

        menuPresenter.showMainTitle()
        mainManuOption = readLine()!!.toInt()

        when (mainManuOption) {
            MENU_SALES -> {
                while (runCategorySubMenu) {
                    println("**Elija su Categoria")
                    menuPresenter.showMainMenu()
                    selectedCategoryOption = readLine()!!.toInt()
                    menuPresenter.showAllProductsByCategoryId(selectedCategoryOption)
                    println("Elija su Producto")
                    selectedProductOption = readLine()!!.toInt()
                    menuPresenter.addNewProduct(selectedProductOption)
                    menuPresenter.showOptioncontinueSelecting()
                    answer = readLine()!!.toInt()
                    if (answer == 1) {
                        continue
                    } else {
                        runCategorySubMenu = false
                    }
                }
            }
            MENU_PAYMENTS -> {
            println("SELECCIONE SU MEDIO DE PAGO:")
                menuPresenter.showPayments()
                selectedPaymentOption= readLine()!!.toInt()
                menuPresenter.addNewPayment(selectedPaymentOption)

            }

            MENU_ORDERS -> {
                println("****************")
                println( "COMPRA EXITOSA:")
                println("****************")

                menuPresenter.showAllOrders()

            }
            MENU_EXIT -> {
                runMainProgram = false
            }
            MENU_VER_CARRITO -> {
                menuPresenter.showCart()
                menuPresenter.showCartTotal()
            }
        }

    }

}