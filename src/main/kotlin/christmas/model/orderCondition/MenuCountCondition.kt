package christmas.model.orderCondition

import christmas.model.order.Menu

class MenuCountCondition(menus: Map<Menu, Int>) : MenuCondition(menus) {
    override val isSatisfy: Boolean = TODO()
}