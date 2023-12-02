package christmas.controller

import christmas.misc.ExceptionHandler
import christmas.view.InputView
import christmas.view.OutputView

class MainController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val exceptionHandler: ExceptionHandler,
) {

    fun run() {
        printHello()

        exceptionHandler.inputUntilSuccess { receiveVisitDate() }
    }

    private fun printHello() = outputView.hello()

    private fun receiveVisitDate() {
        outputView.visitDate()
        inputView.inputVisitDate()
    }

    private fun receiveOrder() {
        //String 입력
    }

}