package christmas.view

import christmas.util.InputValidator
import camp.nextstep.edu.missionutils.Console
import christmas.constants.ErrorMessage

class InputView {
    private val validator: InputValidator = InputValidator()

    fun inputVisitDate(): Int {
        val input: String = Console.readLine().trim()
        validator.checkInt(input, ErrorMessage.INVALID_DATE)
        return input.toInt()
    }

    fun inputOrderMenus(): String {
        val input: String = Console.readLine().trim()
        validator.checkOrderMenus(input, ErrorMessage.INVALID_ORDER_MENUS)
        return input
    }
}