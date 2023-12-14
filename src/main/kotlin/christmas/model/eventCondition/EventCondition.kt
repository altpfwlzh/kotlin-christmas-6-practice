package christmas.model.eventCondition

import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate

abstract class EventCondition(val visitDate: VisitDate, val menus: OrderMenus) {
    abstract val isSatisfy: Boolean
}