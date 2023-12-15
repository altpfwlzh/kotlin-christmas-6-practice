package christmas.model.event

import christmas.model.order.MenuCategory
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate

abstract class DiscountEvent(visitDate: VisitDate, menus: OrderMenus) : Event(visitDate, menus) {
    override val eventCategory: EventCategory = EventCategory.DISCOUNT

    abstract val discountMenuCategoryAndAmount: Map<MenuCategory, Int>
}