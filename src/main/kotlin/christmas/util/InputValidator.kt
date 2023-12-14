package christmas.util

import christmas.constants.ErrorMessage
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.regex.Matcher
import java.util.regex.Pattern

class InputValidator {
    private val errorMessage: ErrorMessage = ErrorMessage

    fun checkString(input: String, error: String = "") {
        checkEmpty(input, error)
    }

    fun checkInt(input: String, error: String = "") {
        checkEmpty(input, error)
        checkTypeInt(input, error)
    }

    private fun checkEmpty(input: String, error: String) {
        require(input.isNotEmpty()) { throw IllegalArgumentException(error + errorMessage.INPUT_EMPTY) }
    }

    private fun checkTypeInt(input: String, error: String) {
        require(input.chars().allMatch { Character.isDigit(it) }) {
            throw IllegalArgumentException(error + errorMessage.INPUT_TYPE_NOT_INT)
        }
    }

    private fun checkPattern(input: String, error: String) {
        val pattern: Pattern = Pattern.compile("^\\d{3}-\\d{3,4}-\\d{4}$")
        val matcher: Matcher = pattern.matcher(input)
        require(matcher.find()) {throw IllegalArgumentException(error + errorMessage.INPUT_PATTERN_INVALID)}
    }
}