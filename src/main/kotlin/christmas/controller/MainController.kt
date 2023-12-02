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

        val visitDate: Int = exceptionHandler.inputUntilSuccess { receiveVisitDate() }
        exceptionHandler.inputUntilSuccess { receiveOrder() }
        printEventPreview(visitDate)

    }

    private fun printHello() = outputView.hello()

    private fun receiveVisitDate(): Int {
        outputView.visitDate()
        return (inputView.inputVisitDate())
    }

    private fun printEventPreview(date: Int) = outputView.eventPreview(date)

    private fun receiveOrder() {
        outputView.order()
        inputView.inputString()
    }

}