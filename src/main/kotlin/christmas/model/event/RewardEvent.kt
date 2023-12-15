package christmas.model.event

import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate

enum class RewardCategory {
    None,
    Badge
}

enum class Reward(val rewardCategory: RewardCategory, string: String) {
    //None
    None(RewardCategory.None, "없음"),

    //Badge
    STAR(RewardCategory.Badge, "별"),
    TREE(RewardCategory.Badge, "트리"),
    SANTA(RewardCategory.Badge, "산타")
}

abstract class RewardEvent(visitDate: VisitDate, menus: OrderMenus) : Event(visitDate, menus) {
    override val eventCategory: EventCategory = EventCategory.REWARD
    override val eventName: String = REWARD_EVENT
    abstract val rewardEnumAndCount: Map<Reward, Int>

    companion object {
        const val REWARD_EVENT = "리워드 이벤트"
    }
}