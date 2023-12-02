package christmas.model.orderCondition

import christmas.model.order.Menu

abstract class MenuCondition(private val orderMenus: Map<Menu, Int>) {
    abstract val isSatisfy: Boolean

    companion object {
        const val INVALID_ORDER = "유효하지 않은 주문입니다. "
    }
}