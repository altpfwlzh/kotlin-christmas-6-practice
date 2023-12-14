package christmas.model.order

import java.text.SimpleDateFormat
import java.time.LocalDate

class VisitDate(
    date: Int,
    month: Int = LocalDate.now().month.value,
    year: Int = LocalDate.now().year,
) {
    var date: Int = date
        private set
    var month: Int = month
        private set
    var year: Int = year
        private set

    init {
        require(isValidateDate(date, month, year)) { throw IllegalArgumentException(INVALID_DATE) }
    }

    fun isBefore(targetDate: LocalDate, endDate: LocalDate): Boolean {
        return targetDate.isBefore(endDate.plusDays(1))
    }

    fun isAfter(targetDate: LocalDate, startDate: LocalDate): Boolean {
        return targetDate.isAfter(startDate.minusDays(1))
    }

    fun isWithinPeriod(targetDate: LocalDate, startDate: LocalDate, endDate: LocalDate): Boolean {
        return targetDate.isAfter(startDate.minusDays(1)) && targetDate.isBefore(endDate.plusDays(1))
    }

    private fun isValidateDate(date: Int, month: Int, year: Int): Boolean {
        return runCatching {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            dateFormat.isLenient = false
            dateFormat.parse("${year}-${month}-${date}")
            true
        }.getOrElse {
            return false
        }
    }

    companion object {
        const val INVALID_DATE = "유효하지 않은 날짜입니다."
    }
}