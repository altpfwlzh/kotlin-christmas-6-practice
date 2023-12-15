package christmas.model.event

import christmas.model.eventCondition.EventCondition
import christmas.model.order.Menu
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate

abstract class GiftEvent(visitDate: VisitDate, menus: OrderMenus) : Event(visitDate, menus) {
    override val eventCategory: EventCategory = EventCategory.GIFT
    override val eventName: String = EVENT_NAME
    abstract val giftMenuAndCount: Map<Menu, Int>

    companion object {
        const val EVENT_NAME = "증정 이벤트"
    }
}