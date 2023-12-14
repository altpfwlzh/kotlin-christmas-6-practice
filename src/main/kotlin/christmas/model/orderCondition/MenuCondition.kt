package christmas.model.orderCondition

import christmas.model.order.Menu

abstract class MenuCondition(open val menus: Map<Menu, Int>) {
    abstract val isSatisfy: Boolean
}