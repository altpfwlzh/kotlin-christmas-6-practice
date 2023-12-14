package christmas.util

import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.round

class Parser {
    fun intToCashString(num: Long): String {
        val dec = DecimalFormat("#,###원")
        return dec.format(num)
    }

    fun intToMinusCashString(num: Long): String {
        val dec = DecimalFormat("-#,###원")
        return dec.format(num)
    }

    fun doubleToRound(percent: Double, decimalPoint: Int): Double {
        val decimalPointValue: Double = 10.0.pow(decimalPoint)
        return round(percent * decimalPointValue) / decimalPointValue
    }

    fun <K, V> mapValueToKey(map: Map<K, V>, target: V): K {
        return map.keys.first { target == map[it] }
    }
}