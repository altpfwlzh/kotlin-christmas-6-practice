package christmas.model.orderCondition

import christmas.model.order.Menu

abstract class MenuCondition(menus: Map<Menu, Int>) {
    abstract val isSatisfy: Boolean
}