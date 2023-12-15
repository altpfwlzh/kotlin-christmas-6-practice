package christmas.model.event

import christmas.model.eventCondition.EventCondition
import christmas.model.eventCondition.EventConditionPeriod
import christmas.model.eventCondition.EventConditionPrice
import christmas.model.order.Menu
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate
import java.time.LocalDate

enum class EventCategory(val string: String) {
    DEFAULT("이벤트 종류"), DISCOUNT("할인 이벤트"), GIFT("증정 이벤트"), REWARD("리워드")
}

abstract class Event(val visitDate: VisitDate, val menus: OrderMenus) {
    open val eventCategory: EventCategory = EventCategory.DEFAULT
    open val eventName: String = EVENT_NAME
    open val essentialConditions: List<EventCondition> = listOf(
        EventConditionPrice(visitDate, menus, null, MIN_PRICE),
        EventConditionPeriod(visitDate, menus, LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31))
    )
    open val optionalConditions: List<EventCondition> = listOf()
    abstract val isSatisfy: Boolean

    open fun isAllConditionsSatisfy(): Boolean = essentialConditions.all { it.isSatisfy }
    open fun isSomeConditionSatisfy(): Boolean =
        (essentialConditions.all { it.isSatisfy } && optionalConditions.any { it.isSatisfy })

    companion object {
        const val EVENT_NAME = "이벤트 이름"
        const val MIN_PRICE = 10_000
    }
}