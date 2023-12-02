package christmas.model.order

import christmas.model.orderCondition.MenuCategoryCondition
import christmas.model.orderCondition.MenuCountCondition
import christmas.model.orderCondition.OrderCondition

class OrderMenus(private val orderMenus: Map<Menu, Int>) {
    private val conditions: List<OrderCondition> =
        listOf(MenuCategoryCondition(orderMenus), MenuCountCondition(orderMenus))

    init {

    }

    private fun isConditionsSatisfy(): Boolean = conditions.all { it.isSatisfy }


}