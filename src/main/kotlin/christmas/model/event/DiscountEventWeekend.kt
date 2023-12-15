package christmas.model.event

import christmas.model.eventCondition.EventCondition
import christmas.model.eventCondition.EventConditionDay
import christmas.model.order.MenuCategory
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate
import java.time.DayOfWeek

class DiscountEventWeekend(visitDate: VisitDate, menus: OrderMenus) : DiscountEvent(visitDate, menus) {
    override val eventName: String = WEEKEND_DISCOUNT
    override val essentialConditions: List<EventCondition> = super.essentialConditions + EventConditionDay(
        visitDate,
        menus,
        listOf(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY)
    )
    override val isSatisfy: Boolean = super.isAllConditionsSatisfy()
    override val discountMenuCategoryAndAmount: Map<MenuCategory, Int> =
        mapOf(MenuCategory.MAIN to DISCOUNT_AMOUNT * menus.calculateMenuCategoryCount(MenuCategory.MAIN))

    companion object {
        const val WEEKEND_DISCOUNT = "주말 할인"
        const val DISCOUNT_AMOUNT = 2_023
    }
}