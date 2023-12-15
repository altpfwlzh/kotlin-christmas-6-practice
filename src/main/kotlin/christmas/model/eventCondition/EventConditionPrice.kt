package christmas.model.eventCondition

import christmas.model.order.MenuCategory
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate

class EventConditionPrice(
    visitDate: VisitDate, menus: OrderMenus, menuCategory: MenuCategory? = null, price: Int
) : EventCondition(visitDate, menus) {
    override val isSatisfy: Boolean = isMorePrice(menuCategory, price)

    private fun isMorePrice(menuCategory: MenuCategory?, price: Int): Boolean {
        menuCategory?.let {
            return menus.calculateTotalPrice(menuCategory) >= price
        }
        return menus.calculateTotalPrice() >= price
    }
}