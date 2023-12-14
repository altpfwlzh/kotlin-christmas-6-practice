package christmas.util

import org.junit.jupiter.api.Test

class Util {
    fun calculatePercent(targetCase: Long, totalCase: Long): Double {
        return (targetCase.toDouble() / totalCase.toDouble()) * 100
    }
}