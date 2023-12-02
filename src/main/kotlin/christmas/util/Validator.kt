package christmas.util

import christmas.constants.ErrorMessage
import java.text.SimpleDateFormat
import java.time.LocalDate

class Validator {
    private val errorMessage: ErrorMessage = ErrorMessage

    fun checkString(input: String) {
        checkEmpty(input)
    }

    fun checkInt(input: String) {
        checkEmpty(input)
        checkTypeInt(input)
    }

    fun checkVisitDate(input: String) {
        require(isNotEmpty(input) && isTypeInt(input) && isValidDate(input.toInt())) {
            throw IllegalArgumentException(
                errorMessage.INVALID_DATE
            )
        }
    }

    private fun isNotEmpty(input: String): Boolean = input.isNotEmpty()

    private fun isTypeInt(input: String): Boolean = input.chars().allMatch { Character.isDigit(it) }

    private fun checkEmpty(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException(errorMessage.INPUT_EMPTY)
    }

    private fun checkTypeInt(input: String) {
        require(input.chars().allMatch { Character.isDigit(it) }) {
            throw IllegalArgumentException(errorMessage.INPUT_TYPE_NOT_INT)
        }
    }

    private fun isValidDate(
        date: Int,
        month: Int = LocalDate.now().month.value,
        year: Int = LocalDate.now().year
    ): Boolean {
        return runCatching {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            dateFormat.isLenient = false
            dateFormat.parse("${year}-${month}-${date}")
            true
        }.getOrElse {
            return false
        }
    }
}