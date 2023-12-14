package christmas.util

import christmas.constants.ErrorMessage
import christmas.constants.Strings
import christmas.model.order.Menu
import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.round

class Parser {
    fun stringToOrderMenus(input: String): Map<Menu, Int> {
        val menus:MutableMap<Menu, Int> = mutableMapOf()

        input.split(",").map {
            val menu: String = it.substringBefore("-")
            val count: String = input.substringAfter("-")
            InputValidator().checkOrderMenusDetail(it.substringBefore("-"), input.substringAfter("-"), Strings.INVALID_ORDER_MENUS)

            menus[Menu.valueOf(string = menu)] = count.toInt()
        }
        return menus
    }

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