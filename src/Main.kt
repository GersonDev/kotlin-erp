import presentation.MenuPresenter
import util.MENU_EMPLOYEE
import util.MENU_EXIT
import util.MENU_ORDERS
import util.MENU_SALES

fun main(array: Array<String>) {

    // Presenters
    val menuPresenter = MenuPresenter()

    var mainManuOption = 0
    var runMainProgram = true

    while (runMainProgram) {

        menuPresenter.showMainTitle()
        mainManuOption = readLine()!!.toInt()

        when (mainManuOption) {
            MENU_SALES -> {

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