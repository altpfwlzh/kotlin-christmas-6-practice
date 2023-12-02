package christmas.model.orderCondition

import christmas.model.order.Menu

class MenuCountCondition(private val orderMenus: Map<Menu, Int>) : MenuCondition(orderMenus) {
    override val isSatisfy: Boolean = isOverMinCnt() && isUnderMaxCnt()

    init {
        require(isUnderMaxCnt()) { throw IllegalArgumentException(OVER_MAX_CNT) }
        require(isOverMinCnt()) { throw IllegalArgumentException(UNDER_MIN_CNT) }
    }

    private fun isUnderMaxCnt(): Boolean {
        var totalCount: Int = 0

        orderMenus.values.map {
            totalCount += it
            if (totalCount > MAX_CNT) return false
        }
        return true
    }

    private fun isOverMinCnt(): Boolean {
        orderMenus.values.map {
            if(it < MIN_CNT) return false
        }
        return true
    }

    companion object {
        const val MIN_CNT = 1
        const val MAX_CNT = 20
        const val OVER_MAX_CNT = "한 번에 주문할 수 있는 메뉴의 개수는 ${MAX_CNT}개 이하입니다.(음료 포함)"
        const val UNDER_MIN_CNT = "메뉴는 ${MIN_CNT}개 이상 주문해야 합니다."
    }
}