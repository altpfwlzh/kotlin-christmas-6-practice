package christmas.model.eventCondition

import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate
import java.time.DayOfWeek
import java.time.LocalDate

class EventConditionDay(visitDate: VisitDate, menus: OrderMenus, private val days: List<DayOfWeek>)
    : EventCondition(visitDate, menus) {
    override val isSatisfy: Boolean = isDateWithinDays()

    private fun isDateWithinDays(): Boolean
        = days.contains(LocalDate.of(visitDate.year, visitDate.month, visitDate.date).dayOfWeek)

}