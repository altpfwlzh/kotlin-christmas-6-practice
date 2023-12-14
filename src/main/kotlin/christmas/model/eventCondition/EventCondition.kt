package christmas.model.eventCondition

import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate

abstract class EventCondition(open val visitDate: VisitDate, open val menus: OrderMenus) {
    abstract val isSatisfy: Boolean
}