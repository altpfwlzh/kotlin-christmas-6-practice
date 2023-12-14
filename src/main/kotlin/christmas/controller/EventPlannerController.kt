package christmas.controller

import christmas.misc.ExceptionHandler
import christmas.model.order.VisitDate
import christmas.view.InputView
import christmas.view.OutputView

class EventPlannerController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val exceptionHandler: ExceptionHandler,
) {

    fun run() {
        printHello()

        val visitDate: VisitDate = exceptionHandler.inputUntilSuccess { receiveVisitDate() }

    }

    private fun printHello() {
        outputView.outputHello()
    }

    private fun receiveVisitDate(): VisitDate {
        outputView.outputReceiveVisitDate()
        return VisitDate(inputView.inputVisitDate())
    }

}