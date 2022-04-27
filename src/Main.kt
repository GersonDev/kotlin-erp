import domain.models.Category
import presentation.MenuPresenter
import util.MENU_EMPLOYEE
import util.MENU_EXIT
import util.MENU_ORDERS
import util.MENU_SALES

fun main(array: Array<String>) {
    var runMainProgram = true
    var excecuterunsubmainmenu = true
    // Presenters
    var selectedProductOption = 0


    val menuPresenter = MenuPresenter()

    var mainManuOption = 0
    var answer = 0

    while (runMainProgram) {

        menuPresenter.showMainTitle()
        mainManuOption = readLine()!!.toInt()

        when (mainManuOption) {
            MENU_SALES -> {
                while (excecuterunsubmainmenu) {
                    println("**Elija su Categoria")
                    menuPresenter.showMainMenu()
                    selectedProductOption = readLine()!!.toInt()
                    menuPresenter.showAllProductsByCategoryId(selectedProductOption)
                    menuPresenter.showOptioncontinueSelecting()
                    answer = readLine()!!.toInt()
                    if (answer == 1) {
                        continue
                    } else {
                        excecuterunsubmainmenu = false
                    }
                }
            }
            MENU_EMPLOYEE -> {

            }
            MENU_ORDERS -> {

            }
            MENU_EXIT -> {
                runMainProgram = false
            }

        }

    }

}