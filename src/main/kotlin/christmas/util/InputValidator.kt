package christmas.util

import christmas.constants.ErrorMessage

class InputValidator {
    private val errorMessage: ErrorMessage = ErrorMessage

    fun checkInt(input: String, error: String = "") {
        checkEmpty(input, error)
        checkTypeInt(input, error)
    }

    fun checkOrderMenus(input: String, error: String = "") {
        checkEmpty(input, error)
        checkContainSeparator(input, error)
    }

    private fun checkEmpty(input: String, error: String) {
        require(input.isNotEmpty()) { throw IllegalArgumentException(error + errorMessage.INPUT_EMPTY) }
    }

    private fun checkTypeInt(input: String, error: String) {
        require(input.chars().allMatch { Character.isDigit(it) }) {
            throw IllegalArgumentException(error + errorMessage.INPUT_TYPE_NOT_INT)
        }
    }

    private fun checkContainSeparator(input: String, error: String) {
        require(input.contains("-") && input.count { it == '-' } >= input.count { it == ',' }) {
            throw IllegalArgumentException(error + errorMessage.INPUT_ORDER_MENUS_PATTERN_INVALID)
        }
    }
}