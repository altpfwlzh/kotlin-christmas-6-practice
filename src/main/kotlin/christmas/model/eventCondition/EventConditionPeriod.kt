package christmas.model.eventCondition

import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate
import java.time.LocalDate

class EventConditionPeriod(
    visitDate: VisitDate, menus: OrderMenus, startDate: LocalDate, endDate: LocalDate
) :
    EventCondition(visitDate, menus) {
    override val isSatisfy: Boolean = isDateWithinPeriod(startDate, endDate)

    private fun isDateWithinPeriod(startDate: LocalDate, endDate: LocalDate): Boolean {
        return visitDate.isWithinPeriod(
            LocalDate.of(visitDate.year, visitDate.month, visitDate.date),
            startDate,
            endDate
        )
    }
}