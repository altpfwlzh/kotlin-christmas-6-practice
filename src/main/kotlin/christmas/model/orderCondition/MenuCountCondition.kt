package christmas.model.orderCondition

import christmas.constants.Strings
import christmas.model.order.Menu

class MenuCountCondition(override val menus: Map<Menu, Int>) : MenuCondition(menus) {
    override val isSatisfy: Boolean = isMenuCountInRange()

    init {
        require(isMenuCountInRange()) {throw (IllegalArgumentException(Strings.INVALID_ORDER_MENUS + OUT_OF_RANGE))}
    }

    private fun isMenuCountInRange() = calculateMenuCount() in MIN_CNT..MAX_CNT

    private fun calculateMenuCount(): Int {
        var totalMenuCount: Int = 0

        menus.map {
            totalMenuCount += it.value
        }

        return totalMenuCount
    }


    companion object {
        const val MIN_CNT = 1
        const val MAX_CNT = 20
        const val OUT_OF_RANGE = "주문 가능한 총 메뉴는 $MIN_CNT ~ ${MAX_CNT}개 사이여야 합니다."
    }
}