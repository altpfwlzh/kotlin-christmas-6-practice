package christmas.model.eventCondition

import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate
import java.time.LocalDate

class EventConditionPeriod(
    visitDate: VisitDate, menus: OrderMenus,
    private val startDate: LocalDate, private val endDate: LocalDate
) :
    EventCondition(visitDate, menus) {
    override val isSatisfy: Boolean = isDateWithinPeriod()

    private fun isDateWithinPeriod(): Boolean {
        return visitDate.isWithinPeriod(
            LocalDate.of(visitDate.year, visitDate.month, visitDate.date),
            startDate,
            endDate
        )
    }
}