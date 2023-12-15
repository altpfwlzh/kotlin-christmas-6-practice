package christmas.view

import christmas.constants.ErrorMessage
import christmas.constants.Strings
import christmas.model.order.Menu
import java.time.LocalDate
import christmas.util.Parser


class OutputView() {
    private val strings: Strings = Strings
    private val errorMessage: ErrorMessage = ErrorMessage

    private val currentMonth: Int =  LocalDate.now().month.value

    fun outputHello() = println(strings.OUTPUT_HELLO.format(currentMonth))

    fun outputReceiveVisitDate() = println(strings.OUTPUT_RECEIVE_VISIT_DATE.format(currentMonth))

    fun outputReceiveOrderMenus() = println(strings.OUTPUT_RECEIVE_ORDER_MENUS)

    fun outputPreviewEventInfo(visitDate: Int) = println(strings.OUTPUT_PREVIEW_EVENT_INFO.format(currentMonth, visitDate))

    fun outputOrderMenus(menusDetail: Map<String, Int>) {
        outputBlankLine()
        println(strings.OUTPUT_ORDER_MENUS)
        menusDetail.map {
            println("${it.key} ${it.value}${strings.OUTPUT_MENU_UNIT}")
        }
    }

    fun outputTotalPriceBeforeDiscount(price: Int) {
        outputBlankLine()
        println(strings.OUTPUT_TOTAL_PRICE_BEFORE_DISCOUNT)
        println(Parser().longToCashString(price.toLong()))
    }

    fun outputGiftMenu(giftDetails: Map<Menu, Int>) {
        outputBlankLine()
        println(strings.OUTPUT_GIFT_MENU)
        if(giftDetails.isEmpty()) return println(strings.OUTPUT_NONE)
        giftDetails.map {
            println("${it.key.string} ${it.value}${strings.OUTPUT_MENU_UNIT}")
        }
    }

    fun outputBenefitDetail() = println(strings.OUTPUT_BENEFIT_DETAIL)

    fun outputTotalBenefitAmount() = println(strings.OUTPUT_TOTAL_BENEFIT_AMOUNT)

    fun outputTotalPriceAfterDiscount() = println(strings.OUTPUT_TOTAL_PRICE_AFTER_DISCOUNT)

    fun outputEventBadge() = println(strings.OUTPUT_EVENT_BADGE)

    private fun outputBlankLine() = println()
}