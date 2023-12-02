package christmas.model.orderCondition

import christmas.model.order.Menu
import christmas.model.order.MenuCategory

class MenuCategoryCondition(private val orderMenus: Map<Menu, Int>) : OrderCondition(orderMenus) {
    override val isSatisfy: Boolean = isNotOnlyDrink()

    init {
        require(isNotOnlyDrink()) {throw IllegalArgumentException(INVALID_ORDER + INVALID_ORDER_ONLY_DRINK)}
    }

    private fun isNotOnlyDrink(): Boolean {
        orderMenus.map {
            if(it.key.menuCategory != MenuCategory.DRINK) return true
        }
        return false
    }

    companion object {
        const val INVALID_ORDER_ONLY_DRINK = "음료만 주문하는 것은 불가능합니다."
    }
}