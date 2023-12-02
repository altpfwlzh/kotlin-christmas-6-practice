package christmas.view

import christmas.constants.ErrorMessage
import christmas.constants.Strings
import java.time.LocalDate
import java.util.Locale

class OutputView() {
    private val strings: Strings = Strings
    private val errorMessage: ErrorMessage = ErrorMessage

    private val curMonth: Int = LocalDate.now().month.value

    fun hello() = println(strings.OUTPUT_HELLO.format(curMonth))

    fun visitDate() = println(strings.OUTPUT_VISIT_DATE.format(curMonth))

    fun eventPreview(date: Int) = println(strings.OUTPUT_EVENT_PREVIEW.format(curMonth, date))

    fun order() = println(strings.OUTPUT_ORDER)

    fun orderMenu() = println(strings.OUTPUT_ORDER_MENU)

    fun totalAmountBeforeDiscount() = println(strings.OUTPUT_TOTAL_AMOUNT_BEFORE_DISCOUNT)

    fun giftDetail() = println(strings.OUTPUT_GIFT_DETAIL)

    fun benefitDetail() = println(strings.OUTPUT_BENEFIT_DETAIL)

    fun totalDiscountAmount() = println(strings.OUTPUT_TOTAL_DISCOUNT_AMOUNT)

    fun totalAmountAfterDiscount() = println(strings.OUTPUT_TOTAL_AMOUNT_AFTER_DISCOUNT)

    fun badgeDetail() = println(strings.OUTPUT_BADGE_DETAIL)

    fun blankLine() = println()
}