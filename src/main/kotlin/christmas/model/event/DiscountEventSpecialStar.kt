package christmas.model.event

import christmas.model.eventCondition.EventCondition
import christmas.model.eventCondition.EventConditionDay
import christmas.model.eventCondition.EventConditionPeriod
import christmas.model.order.MenuCategory
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate
import java.time.DayOfWeek
import java.time.LocalDate

class DiscountEventSpecialStar(visitDate: VisitDate, menus: OrderMenus) : DiscountEvent(visitDate, menus){
    override val eventName: String = EVENT_NAME
    override val optionalConditions: List<EventCondition> = listOf(
        EventConditionDay(visitDate, menus, listOf(DayOfWeek.SUNDAY)),
        EventConditionPeriod(visitDate, menus, LocalDate.of(2023,12,25), LocalDate.of(2023,12,25))
    )
    override val isSatisfy: Boolean = super.isSomeConditionSatisfy()

    override val discountMenuCategoryAndAmount: Map<MenuCategory, Int> = mapOf(MenuCategory.NONE to DISCOUNT_AMOUNT)

    companion object {
        const val EVENT_NAME = "특별 할인"
        const val DISCOUNT_AMOUNT = 1_000
    }

}