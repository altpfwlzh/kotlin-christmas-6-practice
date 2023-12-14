package christmas.model.event

import christmas.model.order.Menu
import christmas.model.order.VisitDate

abstract class Event(open val visitDate: VisitDate, open val menus: Map<Menu, Int>) {
}