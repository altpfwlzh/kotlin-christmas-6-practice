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

        printUserOrder(visitDate, orderMenus)
        printEventInfo(visitDate, orderMenus)
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

    private fun printUserOrder(visitDate: VisitDate, orderMenus: OrderMenus) {
        printPreviewEventInfo(visitDate.date)

        printOrderMenus(orderMenus)
        printTotalPriceBeforeDiscount(orderMenus)
    }

    private fun printEventInfo(visitDate: VisitDate, menus: OrderMenus) {
        val eventController = EventController(visitDate, menus)

        outputView.outputGiftMenu(eventController.calculateGiftMenuAndCount())
        outputView.outputBenefitDetail(eventController.calculateDiscountEventNameAndDiscountAmount(), eventController.calculateGiftEventNameAndGiftAmount())
    }

    private fun printPreviewEventInfo(visitDate: Int) = outputView.outputPreviewEventInfo(visitDate)

    private fun printOrderMenus(orderMenus: OrderMenus) = outputView.outputOrderMenus(orderMenus.getMenusKeyToString())

    private fun printTotalPriceBeforeDiscount(orderMenus: OrderMenus) =
        outputView.outputTotalPriceBeforeDiscount(orderMenus.calculateTotalPrice())
}