package christmas.view

import christmas.constants.ErrorMessage
import christmas.constants.Strings

class OutputView() {
    private val strings: Strings = Strings
    private val errorMessage: ErrorMessage = ErrorMessage

    fun hello() = println(strings.OUTPUT_HELLO)

    fun visitDate() = println(strings.OUTPUT_VISIT_DATE)

    fun eventPreview() = println(strings.OUTPUT_EVENT_PREVIEW)

    fun order() = println(strings.OUTPUT_ORDER)

    fun orderMenu() = println(strings.OUTPUT_ORDER_MENU)

    fun totalAmountBeforeDiscount() = println(strings.OUTPUT_TOTAL_AMOUNT_BEFORE_DISCOUNT)

    fun giftDetail() = println(strings.OUTPUT_GIFT_DETAIL)

    fun benefitDetail() = println(strings.OUTPUT_BENEFIT_DETAIL)

    fun totalDiscountAmount() = println(strings.OUTPUT_TOTAL_DISCOUNT_AMOUNT)

    fun totalAmountAfterDiscount() = println(strings.OUTPUT_TOTAL_AMOUNT_AFTER_DISCOUNT)

    fun badgeDetail() = println(strings.OUTPUT_BADGE_DETAIL)
}