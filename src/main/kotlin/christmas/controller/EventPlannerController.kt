package christmas.controller

import christmas.misc.ExceptionHandler
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate
import christmas.view.InputView
import christmas.view.OutputView
import christmas.util.Parser

class EventPlannerController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val exceptionHandler: ExceptionHandler,
) {

    fun run() {
        printHello()

        val visitDate: VisitDate = exceptionHandler.inputUntilSuccess { receiveVisitDate() }
        val orderMenus: OrderMenus = exceptionHandler.inputUntilSuccess { receiveOrderMenus() }

        printPreviewEventInfo(visitDate.date)
    }

    private fun printHello() {
        outputView.outputHello()
    }

    private fun receiveVisitDate(): VisitDate {
        outputView.outputReceiveVisitDate()
        return VisitDate(inputView.inputVisitDate())
    }

    private fun receiveOrderMenus(): OrderMenus {
        outputView.outputReceiveOrderMenus()
        return OrderMenus(Parser().stringToOrderMenus(inputView.inputOrderMenus()))
    }

    private fun printPreviewEventInfo(visitDate: Int) = outputView.outputPreviewEventInfo(visitDate)
}