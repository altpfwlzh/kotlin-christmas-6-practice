package christmas.view

import christmas.util.InputValidator
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator: InputValidator = InputValidator()

    fun inputVisitDate(): Int {
        val input: String = Console.readLine().trim()
        validator.checkInt(input, INVALID_DATE)
        return input.toInt()
    }

    fun inputOrderMenus(): String {
        val input: String = Console.readLine().trim()
        validator.checkOrderMenus(input, INVALID_ORDER_MENUS)
        return input
    }

    companion object {
        const val INVALID_DATE = "유효하지 않은 날짜입니다. "
        const val INVALID_ORDER_MENUS = "유효하지 않은 주문입니다. "
    }
}