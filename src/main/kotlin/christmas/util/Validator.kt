package christmas.util

import christmas.constants.ErrorMessage

class Validator {
    private val errorMessage: ErrorMessage = ErrorMessage

    fun checkString(input: String) {
        checkEmpty(input)
    }

    fun checkInt(input: String) {
        checkEmpty(input)
        checkTypeInt(input)
    }

    private fun checkEmpty(input: String) {
        if(input.isEmpty()) throw IllegalArgumentException(errorMessage.INPUT_EMPTY)
    }

    private fun checkTypeInt(input: String) {
        require(input.chars().allMatch{ Character.isDigit(it) }) {
            throw IllegalArgumentException(errorMessage.INPUT_TYPE_NOT_INT)
        }
    }
}