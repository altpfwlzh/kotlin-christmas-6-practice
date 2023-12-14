package christmas.model.event

import christmas.model.eventCondition.EventCondition
import christmas.model.order.Menu
import christmas.model.order.VisitDate

enum class EventCategory(val string: String) {
    DEFAULT("이벤트 종류"),
    DISCOUNT("할인 이벤트"),
    GIFT("증정 이벤트"),
    REWARD("리워드")
}

abstract class Event(open val visitDate: VisitDate, open val menus: Map<Menu, Int>) {
    open val eventCategory: EventCategory = EventCategory.DEFAULT
    open val eventName: String = EVENT_NAME
    open val essentialConditions: List<EventCondition> = listOf()
    open val optionalConditions: List<EventCondition> = listOf()

    open fun isAllConditionsSatisfy(): Boolean = essentialConditions.all { it.isSatisfy }
    open fun isSomeConditionSatisfy(): Boolean =
        (essentialConditions.all { it.isSatisfy } && optionalConditions.any { it.isSatisfy })

    companion object {
        const val EVENT_NAME = "이벤트 이름"
    }
}