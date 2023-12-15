package christmas.model.event

import christmas.model.eventCondition.EventCondition
import christmas.model.eventCondition.EventConditionPrice
import christmas.model.order.Menu
import christmas.model.order.MenuCategory
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate

class GiftEventChampagne(visitDate: VisitDate, menus: OrderMenus) : GiftEvent(visitDate, menus) {
    override val essentialConditions: List<EventCondition> = super.essentialConditions + EventConditionPrice(
        visitDate,
        menus,
        MenuCategory.NONE,
        MIN_PRICE
    )
    override val isSatisfy: Boolean = super.isAllConditionsSatisfy()
    override val giftMenuAndCount: Map<Menu, Int> = mapOf(Menu.CHAMPAGNE to 1)

    companion object {
        const val MIN_PRICE = 120_000
    }
}