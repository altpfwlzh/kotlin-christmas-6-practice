package christmas.model.event

import christmas.model.eventCondition.EventCondition
import christmas.model.eventCondition.EventConditionPeriod
import christmas.model.order.MenuCategory
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate
import java.time.LocalDate

class DiscountEventChristmasDDay(visitDate: VisitDate, menus: OrderMenus) : DiscountEvent(visitDate, menus) {
    override val eventName: String = CHRISTMAS_DDAY_DISCOUNT
    override val essentialConditions: List<EventCondition> = super.essentialConditions +
            EventConditionPeriod(visitDate, menus, LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25))
    override val isSatisfy: Boolean = super.isAllConditionsSatisfy()

    override val discountMenuCategoryAndAmount: Map<MenuCategory, Int> =
        mutableMapOf(MenuCategory.NONE to START_AMOUNT + (visitDate.date - 1) * STEP_AMOUNT)

    companion object {
        const val CHRISTMAS_DDAY_DISCOUNT = "크리스마스 디데이 할인"
        const val START_AMOUNT = 1_000
        const val STEP_AMOUNT = 100
    }
}