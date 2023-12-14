package christmas.view

import christmas.constants.ErrorMessage
import christmas.constants.Strings
import java.time.LocalDate

class OutputView() {
    private val strings: Strings = Strings
    private val errorMessage: ErrorMessage = ErrorMessage

    private val currentMonth: Int =  LocalDate.now().month.value

    fun outputHello() = println(strings.OUTPUT_HELLO)

    fun outputReceiveVisitDate() = println(strings.OUTPUT_RECEIVE_VISIT_DATE.format(currentMonth))

    fun outputPreviewEventInfo() = println(strings.OUTPUT_PREVIEW_EVENT_INFO.format(currentMonth))

    fun outputReceiveOrderMenus() = println(strings.OUTPUT_RECEIVE_ORDER_MENUS.format(currentMonth))

    fun outputOrderMenus() = println(strings.OUTPUT_ORDER_MENUS)

    fun outputTotalPriceBeforeDiscount() = println(strings.OUTPUT_TOTAL_PRICE_BEFORE_DISCOUNT)

    fun outputGiftMenu() = println(strings.OUTPUT_GIFT_MENU)

    fun outputBenefitDetail() = println(strings.OUTPUT_BENEFIT_DETAIL)

    fun outputTotalBenefitAmount() = println(strings.OUTPUT_TOTAL_BENEFIT_AMOUNT)

    fun outputTotalPriceAfterDiscount() = println(strings.OUTPUT_TOTAL_PRICE_AFTER_DISCOUNT)

    fun outputEventBadge() = println(strings.OUTPUT_EVENT_BADGE)

    private fun outputBlankLine() = println()
}