package christmas.misc

import christmas.constants.ErrorMessage

class ExceptionHandler {
    private val errorMessage: ErrorMessage = ErrorMessage

    fun <T> inputUntilSuccess(fn: () -> T ) : T {
        return runCatching(fn).onSuccess {
            return it
        }.getOrElse {
            printError(it.message + " ${errorMessage.INPUT_AGAIN}\n")
            return inputUntilSuccess(fn)
        }
    }

    fun printError(e: String?) {
        println("${errorMessage.ERROR_PREFIX} ${e ?: errorMessage.UNKNOWN_ERROR}")
    }
}