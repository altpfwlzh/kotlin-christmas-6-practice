package christmas.model.event

import christmas.model.eventCondition.EventCondition
import christmas.model.eventCondition.EventConditionDay
import christmas.model.order.MenuCategory
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate
import java.time.DayOfWeek

class DiscountEventWeekDay(visitDate: VisitDate, menus: OrderMenus) : DiscountEvent(visitDate, menus) {
    override val eventName: String = EVENT_NAME
    override val essentialConditions: List<EventCondition> = listOf(
        EventConditionDay(
            visitDate,
            menus,
            listOf(DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY)
        )
    )
    override val isSatisfy: Boolean = super.isAllConditionsSatisfy()
    override val discountMenuCategoryAndAmount: Map<MenuCategory, Int> =
        mapOf(MenuCategory.DESSERT to DISCOUNT_AMOUNT * menus.calculateMenuCategoryCount(MenuCategory.DESSERT))

    companion object {
        const val EVENT_NAME = "평일 할인"
        const val DISCOUNT_AMOUNT = 2_023
    }
}