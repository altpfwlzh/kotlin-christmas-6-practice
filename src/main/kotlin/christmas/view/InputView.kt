package christmas.view

import christmas.util.InputValidator
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator: InputValidator = InputValidator()

    fun inputString(): String {
        val input: String = Console.readLine().trim()
        validator.checkString(input)
        return input
    }

    fun inputInt(): Int {
        val input: String = Console.readLine().trim()
        validator.checkInt(input)
        return input.toInt()
    }

    fun inputVisitDate(): Int {
        val input: String = Console.readLine().trim()
        validator.checkInt(input, INVALID_DATE)
        return input.toInt()
    }

    companion object {
        const val INVALID_DATE = "유효하지 않은 날짜입니다. "
    }
}