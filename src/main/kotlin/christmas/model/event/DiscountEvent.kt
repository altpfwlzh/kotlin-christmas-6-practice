package christmas.model.event

import christmas.model.eventCondition.EventCondition
import christmas.model.order.Menu
import christmas.model.order.VisitDate

class DiscountEvent(visitDate: VisitDate, menus: Map<Menu, Int>) : Event(visitDate, menus) {
    override val eventCategory: EventCategory = EventCategory.DISCOUNT
    override val eventName: String = super.eventName
    override val essentialConditions: List<EventCondition> = super.essentialConditions
    override val optionalConditions: List<EventCondition> = super.optionalConditions

    //abstract val
}