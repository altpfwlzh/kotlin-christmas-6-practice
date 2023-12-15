package christmas.model.event

import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate

class RewardEventBadge(visitDate: VisitDate, menus: OrderMenus, totalDiscountAmount: Int) :
    RewardEvent(visitDate, menus) {
    override val eventName: String = EVENT_NAME
    override val isSatisfy: Boolean = super.isAllConditionsSatisfy()
    override val rewardEnumAndCount: Map<Reward, Int> = calculateBadge(totalDiscountAmount)

    private fun calculateBadge(totalDiscountAmount: Int): Map<Reward, Int> {
        return when (totalDiscountAmount) {
            in 0..<5_000 -> mapOf(Reward.None to 0)
            in 5_000..<10_000 -> mapOf(Reward.STAR to 1)
            in 10_000..<20_000 -> mapOf(Reward.TREE to 1)
            else -> mapOf(Reward.SANTA to 1)
        }
    }

    companion object {
        const val EVENT_NAME = "배지 이벤트"
    }
}