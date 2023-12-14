package christmas

import christmas.controller.EventPlannerController
import christmas.misc.ExceptionHandler
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    runCatching {
        val mainController = EventPlannerController(InputView(), OutputView(), ExceptionHandler())
        mainController.run()
    }.onFailure {
        ExceptionHandler().printError(it.message)
    }
}
