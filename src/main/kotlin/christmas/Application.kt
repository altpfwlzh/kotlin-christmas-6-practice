package christmas

import christmas.controller.MainController
import christmas.misc.ExceptionHandler
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    runCatching {
        val mainController = MainController(InputView(), OutputView(), ExceptionHandler())
        mainController.run()
    }.onFailure {
        ExceptionHandler().printError(it.message)
    }
}
