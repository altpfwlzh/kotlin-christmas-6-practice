package christmas.model.eventCondition

import christmas.model.order.MenuCategory
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate

class EventConditionPrice(
    visitDate: VisitDate, menus: OrderMenus,
    private val menuCategory: MenuCategory? = null, private val price: Int
) : EventCondition(visitDate, menus) {
    override val isSatisfy: Boolean = isMorePrice()

    private fun isMorePrice(): Boolean {
        menuCategory?.let {
            return menus.calculateTotalPrice(menuCategory) >= price
        }
        return menus.calculateTotalPrice() >= price
    }
}